package com.gl.app.repository;

import com.gl.app.database.DatabaseManager;
import com.gl.app.entity.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {
    public Hotel addHotel(Hotel hotel) {
        String sql = "INSERT INTO hotels (name, location) VALUES (?, ?) RETURNING hotel_id";

        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, hotel.getName());
            preparedStatement.setString(2, hotel.getLocation());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                hotel.setHotel_id(resultSet.getInt("hotel_id"));
                resultSet.close();
                return hotel;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Hotel getHotel(int id) {
        String sql = "SELECT * FROM hotels WHERE hotel_id = ?";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int hotel_id = resultSet.getInt("hotel_id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                Hotel hotel = new Hotel(name, location);
                hotel.setHotel_id(hotel_id);
                return hotel;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotels";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Hotel hotel = new Hotel(resultSet.getString("name"), resultSet.getString("location"));
                hotel.setHotel_id(resultSet.getInt("hotel_id"));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }
}
