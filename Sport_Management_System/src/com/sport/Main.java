package com.sport;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("Sports Management System");
                System.out.println("1. Add Team");
                System.out.println("2. Add Player");
                System.out.println("3. Add Match");
                System.out.println("4. Display All Teams");
                System.out.println("5. Display All Players");
                System.out.println("6. Display All Matches");
                System.out.println("7. Update Team");
                System.out.println("8. Update Player");
                System.out.println("9. Update Match");
                System.out.println("10. Delete Team");
                System.out.println("11. Delete Player");
                System.out.println("12. Delete Match");
                System.out.println("13. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addTeam();
                        break;
                    case 2:
                        addPlayer();
                        break;
                    case 3:
                        addMatch();
                        break;
                    case 4:
                        displayAllTeams();
                        break;
                    case 5:
                        displayAllPlayers();
                        break;
                    case 6:
                        displayAllMatches();
                        break;
                    case 7:
                        updateTeam();
                        break;
                    case 8:
                        updatePlayer();
                        break;
                    case 9:
                        updateMatch();
                        break;
                    case 10:
                        deleteTeam();
                        break;
                    case 11:
                        deletePlayer();
                        break;
                    case 12:
                        deleteMatch();
                        break;
                    case 13:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 13.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTeam() throws SQLException {
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();

        TeamDAO teamDAO = new TeamDAO();
        teamDAO.addTeam(teamName);
    }

    private static void addPlayer() throws SQLException {
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        System.out.print("Enter team ID: ");
        int teamId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.addPlayer(playerName, position, teamId);
    }

    private static void addMatch() throws SQLException {
        System.out.print("Enter match date (YYYY-MM-DD): ");
        String matchDateStr = scanner.nextLine();
        Date matchDate = Date.valueOf(matchDateStr);

        System.out.print("Enter result: ");
        String result = scanner.nextLine();
        System.out.print("Enter score: ");
        String score = scanner.nextLine();
        System.out.print("Enter team ID: ");
        int teamId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        MatchDAO matchDAO = new MatchDAO();
        matchDAO.addMatch(matchDate, result, score, teamId);
    }

    private static void displayAllTeams() throws SQLException {
        TeamDAO teamDAO = new TeamDAO();
        teamDAO.displayAllTeams();
    }

    private static void displayAllPlayers() throws SQLException {
        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.displayAllPlayers();
    }

    private static void displayAllMatches() throws SQLException {
        MatchDAO matchDAO = new MatchDAO();
        matchDAO.displayAllMatches();
    }

    private static void updateTeam() throws SQLException {
        System.out.print("Enter team ID to update: ");
        int teamId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new team name: ");
        String teamName = scanner.nextLine();

        TeamDAO teamDAO = new TeamDAO();
        teamDAO.updateTeam(teamId, teamName);
    }

    private static void updatePlayer() throws SQLException {
        System.out.print("Enter player ID to update: ");
        int playerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new player name: ");
        String playerName = scanner.nextLine();
        System.out.print("Enter new position: ");
        String position = scanner.nextLine();
        System.out.print("Enter new team ID: ");
        int teamId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.updatePlayer(playerId, playerName, position, teamId);
    }

    private static void updateMatch() throws SQLException {
        System.out.print("Enter match ID to update: ");
        int matchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new match date (YYYY-MM-DD): ");
        String matchDateStr = scanner.nextLine();
        Date matchDate = Date.valueOf(matchDateStr);
        System.out.print("Enter new result: ");
        String result = scanner.nextLine();
        System.out.print("Enter new score: ");
        String score = scanner.nextLine();
        System.out.print("Enter new team ID: ");
        int teamId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        MatchDAO matchDAO = new MatchDAO();
        matchDAO.updateMatch(matchId, matchDate, result, score, teamId);
    }

    private static void deleteTeam() throws SQLException {
        System.out.print("Enter team ID to delete: ");
        int teamId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        TeamDAO teamDAO = new TeamDAO();
        teamDAO.deleteTeam(teamId);
    }

    private static void deletePlayer() throws SQLException {
        System.out.print("Enter player ID to delete: ");
        int playerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.deletePlayer(playerId);
    }

    private static void deleteMatch() throws SQLException {
        System.out.print("Enter match ID to delete: ");
        int matchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        MatchDAO matchDAO = new MatchDAO();
        matchDAO.deleteMatch(matchId);
    }
}
