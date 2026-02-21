package com.gl.app.entity;

public class Room {
    private int room_number;
    private RoomType type;
    private boolean available;
    private int hotel_id;

    public Room(int room_number, String type, boolean available, int hotel_id) {
        this.room_number = room_number;
        if (type.equals("SINGLE")) {
            this.type = RoomType.SINGLE;
        } else {
            this.type = RoomType.DOUBLE;
        }
        this.available = available;
        this.hotel_id = hotel_id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("room_number: ").append(room_number);
        sb.append(", type: ").append(type);
        sb.append(", available: ").append(available);
        sb.append(", hotel_id: ").append(hotel_id).append("\n");
        return sb.toString();
    }
}
