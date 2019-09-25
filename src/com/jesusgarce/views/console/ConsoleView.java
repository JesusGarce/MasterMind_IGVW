package com.jesusgarce.views.console;

import com.jesusgarce.controllers.*;
import com.jesusgarce.views.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.jesusgarce.MasterMind.CODE_SIZE;
import static com.jesusgarce.MasterMind.MAX_ATTEMPTS;

public class ConsoleView extends View {
    private final Controller controller;
    private ProposedCodeState proposedCodeState;
    private SecretCodeView secretCodeView;

    public ConsoleView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
        System.out.println("MASTER MIND");
        System.out.println("----------------------------------------------------------------------------------------------");
        secretCodeView = new SecretCodeView(startController.getSecretCode());
    }

    @Override
    public void visit(ProposeController proposeController) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        printProposedCodesArray();

        System.out.println("Código a descubrir: **** | Intentos restantes: " + (MAX_ATTEMPTS - proposeController.getAttempts()) + " | Dime tu código: ");
        String stringProposedCode = br.readLine();

        if (stringProposedCode.isEmpty() || stringProposedCode.length() != CODE_SIZE)
            proposedCodeState = ProposedCodeState.BAD_LENGTH;
        else
            proposedCodeState = proposeController.propose(stringProposedCode);

        printProposedState();
    }

    @Override
    public void visit(ResumeController resumeController) throws IOException {
        System.out.println("¿Quieres jugar otra partida? (Pulsa 'S' para jugar de nuevo y 'N' para quitar el juego)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine().toUpperCase();
        switch (answer) {
            case "S":
                resumeController.resume(true);
                break;
            case "N":
                resumeController.resume(false);
                break;
            default:
                System.out.println("No he entendido tu respuesta.");
        }
    }

    private void printProposedCodesArray() {
        for (int i = 0; i < controller.getProposedCodes().size(); i++) {
            ProposedCodeView proposedCodeView = new ProposedCodeView(controller.getProposedCodes().get(i));
            ResultView resultView = new ResultView(controller.getProposedCodes().get(i).getResult());
            System.out.print("Intento " + (i + 1) + ": ");
            proposedCodeView.print();
            resultView.print();
            System.out.println();
        }
    }

    private void printProposedState() {
        switch (proposedCodeState) {
            case BAD_LENGTH:
                System.out.println("El código debe tener 4 caracteres.");
                break;
            case BAD_CHARACTERS:
                System.out.println("Tu respuesta solo debe contenter los caracteres 'R, B, Y, G, O, P' y no puedes repetir ninguno.");
                break;
            case WITHOUT_ATTEMPTS:
                System.out.println("¡HAS PERDIDO! Consumiste todos tus intentos. La partida se ha acabado. El código era: " + secretCodeView.print());
                break;
            case WINNER:
                System.out.println("¡HAS GANADO! Has usado " + controller.getAttempts() + " intentos.");
                break;
            case CONTINUE_PLAYING:
                break;
            default:
                break;
        }
    }

}
