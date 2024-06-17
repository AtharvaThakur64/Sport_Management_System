package com.sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDAO {

    // Method to add a new team
    public void addTeam(String teamName) throws SQLException {
        String sql = "INSERT INTO Teams (team_name) VALUES (?)";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, teamName);
            stmt.executeUpdate();
            System.out.println("Team added successfully.");
        }
    }

    // Method to display all teams
    public void displayAllTeams() throws SQLException {
        String sql = "SELECT * FROM Teams";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Teams:");
            while (rs.next()) {
                System.out.println("Team ID: " + rs.getInt("team_id"));
                System.out.println("Team Name: " + rs.getString("team_name"));
                System.out.println("--------------------");
            }
        }
    }

    // Method to update team name by team ID
    public void updateTeam(int teamId, String newTeamName) throws SQLException {
        String sql = "UPDATE Teams SET team_name = ? WHERE team_id = ?";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newTeamName);
            stmt.setInt(2, teamId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Team updated successfully.");
            } else {
                System.out.println("No team found with ID " + teamId);
            }
        }
    }

    // Method to delete a team by team ID
    public void deleteTeam(int teamId) throws SQLException {
        String sql = "DELETE FROM Teams WHERE team_id = ?";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, teamId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Team deleted successfully.");
            } else {
                System.out.println("No team found with ID " + teamId);
            }
        }
    }
}
