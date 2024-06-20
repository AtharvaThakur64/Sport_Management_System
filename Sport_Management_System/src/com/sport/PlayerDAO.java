package com.sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {
    public void addPlayer(String player_name, String position, int teamId) throws SQLException {
        String sql = "INSERT INTO players (player_name, position, team_id) VALUES (?, ?, ?)";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player_name);
            stmt.setString(2, position);
            stmt.setInt(3, teamId);
            stmt.executeUpdate();
            System.out.println("Player added successfully.");
        }
    }

    public void updatePlayer(int playerId, String player_name, String position, int teamId) throws SQLException {
        String sql = "UPDATE players SET player_name = ?, position = ?, team_id = ? WHERE player_id = ?";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, player_name);
            stmt.setString(2, position);
            stmt.setInt(3, teamId);
            stmt.setInt(4, playerId);
            stmt.executeUpdate();
            System.out.println("Player updated successfully.");
        }
    }

    public void deletePlayer(int playerId) throws SQLException {
        String sql = "DELETE FROM players WHERE player_id = ?";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playerId);
            stmt.executeUpdate();
            System.out.println("Player deleted successfully.");
        }
    }

    public void displayAllPlayers() throws SQLException {
        String sql = "SELECT * FROM players";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("player_id");
                String name = rs.getString("player_name");
                String position = rs.getString("position");
                int teamId = rs.getInt("team_id");
                System.out.println("Player ID: " + id + ", Name: " + name + ", Position: " + position + ", Team ID: " + teamId);
            }
        }
    }
}
