package com.gl.app.repository;

import com.gl.app.database.DatabaseManager;
import com.gl.app.entity.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    public void addReservation(Reservation reservation) {
        String sql = "INSERT INTO reservations (reservation_id, guest_id, room_number, checkindate, checkoutdate, status, hotel_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, reservation.getReservation_id());
            preparedStatement.setInt(2, reservation.getGuest_id());
            preparedStatement.setInt(3, reservation.getRoom_number());
            preparedStatement.setDate(4, new Date(reservation.getCheckInDate().getTime()));
            preparedStatement.setDate(5, new Date(reservation.getCheckOutDate().getTime()));
            preparedStatement.setString(6, reservation.getStatus());
            preparedStatement.setInt(7, reservation.getHotel_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reservation getReservation(int reservation_id) {
        String sql = "SELECT * FROM reservations WHERE reservation_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, reservation_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Reservation(
                        resultSet.getInt("reservation_id"),
                        resultSet.getInt("guest_id"),
                        resultSet.getInt("room_number"),
                        resultSet.getDate("checkindate"),
                        resultSet.getDate("checkoutdate"),
                        resultSet.getInt("hotel_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                reservations.add(new Reservation(
                        resultSet.getInt("reservation_id"),
                        resultSet.getInt("guest_id"),
                        resultSet.getInt("room_number"),
                        resultSet.getDate("checkindate"),
                        resultSet.getDate("checkoutdate"),
                        resultSet.getInt("hotel_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public void updateReservationStatus(int reservation_id, String status) {
        String sql = "UPDATE reservations SET status = ? WHERE reservation_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, reservation_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(int reservation_id) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, reservation_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
