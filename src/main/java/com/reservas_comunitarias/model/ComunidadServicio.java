package com.amenity_reservation_system.model;

public enum ComunidadServicio {
    Piscina("POOL"), Padel("SAUNA"), Gimnasio("GYM");

    private final String name;

    private ComunidadServicio(String value) {
        name = value;
    }

    @Override
    public String toString() {
        return name;
    }
}
