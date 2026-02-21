package com.gl.app.repository;

import com.gl.app.database.DatabaseManager;
import com.gl.app.entity.Guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestRepository {
    public void addGuest(Guest guest) {
        String sql = "INSERT INTO guests (name, email, phone, hotel_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getEmail());
            preparedStatement.setString(3, guest.getPhone());
            preparedStatement.setInt(4, guest.getHotel_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Guest getGuest(int guest_id) {
        String sql = "SELECT * FROM guests WHERE id = ?";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, guest_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Guest(resultSet.getInt("guest_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getInt("hotel_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();
        String sql = "SELECT * FROM guests";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                guests.add(new Guest(resultSet.getInt("guest_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getInt("hotel_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }
}
