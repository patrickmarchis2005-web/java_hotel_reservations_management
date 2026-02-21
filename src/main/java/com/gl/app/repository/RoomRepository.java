package com.gl.app.repository;

import com.gl.app.database.DatabaseManager;
import com.gl.app.entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    public void addRoom(Room room) {
        String sql = "INSERT INTO rooms VALUES(?,?,?,?)";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, room.getRoom_number());
            preparedStatement.setString(2, room.getType().toString());
            preparedStatement.setBoolean(3, room.isAvailable());
            preparedStatement.setInt(4, room.getHotel_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Room getRoom(int room_number) {
        String sql = "SELECT * FROM rooms WHERE room_number = ?";
        try (Connection connection = DatabaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, room_number);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Room(
                        resultSet.getInt("room_number"),
                        resultSet.getString("type"),
                        resultSet.getBoolean("available"),
                        resultSet.getInt("hotel_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Room> getRoomsByHotel(int hotel_id) {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE hotel_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, hotel_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rooms.add(new Room(
                        resultSet.getInt("room_number"),
                        resultSet.getString("type"),
                        resultSet.getBoolean("available"),
                        resultSet.getInt("hotel_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public void updateRoomAvailability(int room_number, boolean available) {
        String sql = "UPDATE rooms SET available = ? WHERE room_number = ?";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, available);
            preparedStatement.setInt(2, room_number);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rooms.add(new Room(
                        resultSet.getInt("room_number"),
                        resultSet.getString("type"),
                        resultSet.getBoolean("available"),
                        resultSet.getInt("hotel_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

}
