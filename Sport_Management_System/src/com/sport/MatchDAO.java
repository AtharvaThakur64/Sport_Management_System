package com.sport;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchDAO {

    // Method to add a new match
    public void addMatch(Date matchDate, String result, String score, int teamId) throws SQLException {
        String sql = "INSERT INTO Matches (match_date, result, score, team_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, matchDate);
            stmt.setString(2, result);
            stmt.setString(3, score);
            stmt.setInt(4, teamId);
            stmt.executeUpdate();
            System.out.println("Match added successfully.");
        }
    }

    // Method to display all matches
    public void displayAllMatches() throws SQLException {
        String sql = "SELECT * FROM Matches";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Matches:");
            while (rs.next()) {
                System.out.println("Match ID: " + rs.getInt("match_id"));
                System.out.println("Match Date: " + rs.getDate("match_date"));
                System.out.println("Result: " + rs.getString("result"));
                System.out.println("Score: " + rs.getString("score"));
                System.out.println("Team ID: " + rs.getInt("team_id"));
                System.out.println("--------------------");
            }
        }
    }

    // Method to update match information by match ID
    public void updateMatch(int matchId, String newResult, String newScore) throws SQLException {
        String sql = "UPDATE Matches SET result = ?, score = ? WHERE match_id = ?";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newResult);
            stmt.setString(2, newScore);
            stmt.setInt(3, matchId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Match updated successfully.");
            } else {
                System.out.println("No match found with ID " + matchId);
            }
        }
    }

    // Method to delete a match by match ID
    public void deleteMatch(int matchId) throws SQLException {
        String sql = "DELETE FROM Matches WHERE match_id = ?";

        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matchId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Match deleted successfully.");
            } else {
                System.out.println("No match found with ID " + matchId);
            }
        }
    }
}
