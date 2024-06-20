package com.sport;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchDAO {
    public void addMatch(Date match_date, String result, String score, int teamId) throws SQLException {
        String sql = "INSERT INTO matches (match_date, result, score, team_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, match_date);
            stmt.setString(2, result);
            stmt.setString(3, score);
            stmt.setInt(4, teamId);
            stmt.executeUpdate();
            System.out.println("Match added successfully.");
        }
    }

    public void updateMatch(int matchId, Date match_date, String result, String score, int teamId) throws SQLException {
        String sql = "UPDATE matches SET match_date = ?, result = ?, score = ?, team_id = ? WHERE match_id = ?";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, match_date);
            stmt.setString(2, result);
            stmt.setString(3, score);
            stmt.setInt(4, teamId);
            stmt.setInt(5, matchId);
            stmt.executeUpdate();
            System.out.println("Match updated successfully.");
        }
    }

    public void deleteMatch(int matchId) throws SQLException {
        String sql = "DELETE FROM matches WHERE match_id = ?";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matchId);
            stmt.executeUpdate();
            System.out.println("Match deleted successfully.");
        }
    }

    public void displayAllMatches() throws SQLException {
        String sql = "SELECT * FROM matches";
        try (Connection conn = Database_con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("match_id");
                Date date = rs.getDate("match_date");
                String result = rs.getString("result");
                String score = rs.getString("score");
                int teamId = rs.getInt("team_id");
                System.out.println("Match ID: " + id + ", Date: " + date + ", Result: " + result + ", Score: " + score + ", Team ID: " + teamId);
            }
        }
    }
}
