package org.drogo.basics.streams.studentengage;

public record Course(String courseCode, String title, int lectureCount) {
    public Course(String courseCode, String title) {
        this(courseCode, title, 40);
    }

    public Course {
        if (lectureCount <= 0) {
            lectureCount = 1;
        }
    }

    @Override
    public String toString() {
        return "%s %s".formatted(courseCode, title);
    }
}
