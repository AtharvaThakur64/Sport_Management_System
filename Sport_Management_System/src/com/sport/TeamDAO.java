package com.sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDAO {

    public void addTeam(String teamName) throws SQLException {
        String sql = "INSERT INTO Teams (team_name) VALUES (?)";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, teamName);
            stmt.executeUpdate();
            System.out.println("Team added successfully.");
        }
    }

    public void updateTeam(int teamId, String teamName) throws SQLException {
        String sql = "UPDATE Teams SET team_name = ? WHERE team_id = ?";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, teamName);
            stmt.setInt(2, teamId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Team updated successfully.");
            } else {
                System.out.println("No team found with ID " + teamId);
            }
        }
    }

    public void deleteTeam(int teamId) throws SQLException {
        String sql = "DELETE FROM Teams WHERE team_id = ?";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, teamId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Team deleted successfully.");
            } else {
                System.out.println("No team found with ID " + teamId);
            }
        }
    }

    public void displayAllTeams() throws SQLException {
        String sql = "SELECT * FROM Teams";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("team_id");
                String name = rs.getString("team_name");
                System.out.println("Team ID: " + id + ", Name: " + name);
            }
        }
    }
}
