package com.sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {

    // Method to add a new player
    public void addPlayer(String playerName, String position, int teamId) throws SQLException {
        String sql = "INSERT INTO Players (player_name, position, team_id) VALUES (?, ?, ?)";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, playerName);
            stmt.setString(2, position);
            stmt.setInt(3, teamId);
            stmt.executeUpdate();
            System.out.println("Player added successfully.");
        }
    }

    // Method to display all players
    public void displayAllPlayers() throws SQLException {
        String sql = "SELECT * FROM Players";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Players:");
            while (rs.next()) {
                System.out.println("Player ID: " + rs.getInt("player_id"));
                System.out.println("Player Name: " + rs.getString("player_name"));
                System.out.println("Position: " + rs.getString("position"));
                System.out.println("Team ID: " + rs.getInt("team_id"));
                System.out.println("--------------------");
            }
        }
    }

    // Method to update player information by player ID
    public void updatePlayer(int playerId, String newPlayerName, String newPosition) throws SQLException {
        String sql = "UPDATE Players SET player_name = ?, position = ? WHERE player_id = ?";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newPlayerName);
            stmt.setString(2, newPosition);
            stmt.setInt(3, playerId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Player updated successfully.");
            } else {
                System.out.println("No player found with ID " + playerId);
            }
        }
    }

    // Method to delete a player by player ID
    public void deletePlayer(int playerId) throws SQLException {
        String sql = "DELETE FROM Players WHERE player_id = ?";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playerId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Player deleted successfully.");
            } else {
                System.out.println("No player found with ID " + playerId);
            }
        }
    }
}
