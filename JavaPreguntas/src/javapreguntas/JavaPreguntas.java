/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapreguntas;

import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author anam1
 */
public class JavaPreguntas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // flujo principal del programa sera utilizada como vista
        // en forma de consola para responder las preguntas y la interacción con el usuario

        Scanner sc = new Scanner(System.in);
        int opc = 1;
        String userName;

        System.out.println("------------------------------");
        System.out.println("------JUEGO DE PREGUNTAS------");
        System.out.println("------------------------------");
        System.out.println("Bienvenido Usuario, por favor ingrese su nombre: ");
        userName = sc.nextLine();

        while (opc == 1) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Opciones: ");
            System.out.println("1 = Jugar");
            System.out.println("0 = Salir");
            try {
                opc = sc1.nextInt();
                if (opc == 1) {
                    presentRounds(userName);
                    opc = 0;
                }
            } catch (Exception e) {
                System.out.println("Error de digitación por favor intente de nuevo" + e);
                opc = 1;

            }
        }


    }

    private static void presentRounds(String userName) throws Exception {
        //ciclo para rondas en total 5 rondas si gana bien todo se recuperan de la base de datos
        RondaController rondaController = new RondaController();
        ArrayList<Ronda> rounds = new ArrayList<>();
        rounds = rondaController.getRounds();

        //crea instancia de Jugador para guardar nombre y puntaje
        JugadorController playerController = new JugadorController();
        Jugador player = new Jugador(userName, 0);

        for (Ronda round : rounds) {
            System.out.println(round.getName());
            if (presentQuestions(round.getId(), player))
                continue;
            else
                break;
        }

        playerController.savePlayer(player);
        //termino
    }

    private static boolean presentQuestions(int idRound, Jugador player) throws Exception {

        PreguntaController preguntaController = new PreguntaController();
        Pregunta question = new Pregunta();
        ArrayList<Pregunta> questions = new ArrayList<>();
        questions = preguntaController.getQuestionsByRonda(idRound);

        //Reward
        PremioController rewardController = new PremioController();
        Premio reward = new Premio();
        reward = rewardController.getAwardByIdRound(idRound);

        //Player
        JugadorController playerController = new JugadorController();

        //Realizamos un aleatorio de 1 a 5 para mostrar la pregunta
        Random random = new Random();
        int questionShow = 1 + random.nextInt(6 - 1);
        System.out.println("pregunta aleatoria: " + questionShow);
        question = questions.get(questionShow - 1);
        System.out.println(question.getStatement());

        //mostramos las opciones
        Opciones optionToValidate = new Opciones();
        OpcionesController opcionesController = new OpcionesController();
        ArrayList<Opciones> options = new ArrayList<>();
        options = opcionesController.getOptionsByQuestion(question.getId());
        for (Opciones option : options) {
            System.out.println(option.getStatement());
        }

        // validaremos la respuesta del usuario
        System.out.println("Selecione la opción correcta o si no deseas continuar presiona 0: ");

        boolean questionOk = false;
        int responseQuestion = 0;


        while (questionOk == false) {
            try {
                Scanner sc1 = new Scanner(System.in);
                responseQuestion = sc1.nextInt();
                if (responseQuestion == 0) {
                    //decidio salir
                    questionOk = true;
                    return false;
                } else {
                    if (responseQuestion == 1 || responseQuestion == 2 || responseQuestion == 3 || responseQuestion == 4) {
                        //opciones validas
                        questionOk = true;
                        //se resta 1 para que tome los valores correctos de la lista de opciones
                        optionToValidate = options.get(responseQuestion - 1);
                        if (optionToValidate.isOptionCorrect()) {
                            System.out.println("¡PERFECTO! Pasas a la siguiente Ronda");
                            //acumulamos el premio ganado
                            player.setReward(player.getReward() + reward.getValor());
                            //Fin del juego:

                            return true;
                        } else {
                            System.out.println("PERDISTE");
                            return false;
                        }
                    } else {
                        System.out.println("Selecione la opción correcta o si no deseas continuar presiona 0: ");
                        questionOk = false;
                    }
                }

            } catch (Exception e) {
                System.out.println("----Error de digitación----");
                System.out.println("Selecione la opción correcta o si no deseas continuar presiona 0: " + e);
                questionOk = false;
            }
        }

        return true;
    }

    //private static void presentOptions(int idQuestion) throws Exception {
    //    OpcionesController opcionesController = new OpcionesController();
    //    ArrayList<Opciones> options = new ArrayList<>();
    //    opcionesController.getOptionsByQuestion(idQuestion);
    //    for(Opciones option: options){
    //        System.out.println(option.getStatement());
    //    }

    //}

}
