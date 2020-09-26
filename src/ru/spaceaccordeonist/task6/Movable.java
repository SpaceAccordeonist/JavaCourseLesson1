package ru.spaceaccordeonist.task6;

public interface Movable {
    void move(Vector vector);

    class Vector{
        private double x, y;

        public Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}
