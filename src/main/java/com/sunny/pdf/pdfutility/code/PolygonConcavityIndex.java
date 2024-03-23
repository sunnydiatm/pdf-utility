package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class PolygonConcavityIndex {

    private static int _IsClockwise(Point2D Point2D_A, Point2D Point2D_B, Point2D Point2D_C) {
        int result = (Point2D_B.x - Point2D_A.x) * (Point2D_C.y - Point2D_A.y) -
                (Point2D_B.y - Point2D_A.y) * (Point2D_C.x - Point2D_A.x);
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int solution(Point2D[] arr) {

        List<Point2D> A = new ArrayList<>();

        for (Point2D point : arr) {
            A.add(point);
        }

        int lowest_y = A.get(0).y;
        List<Integer> lowest_y_index = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).y < lowest_y) {
                lowest_y = A.get(i).y;
                lowest_y_index = new ArrayList<>();
                lowest_y_index.add(i);
            } else if (A.get(i).y == lowest_y) {
                lowest_y_index.add(i);
            }
        }

        int start_Point2D = lowest_y_index.get(0);
        boolean[] lowest_y_array = new boolean[A.size()];
        for (int i : lowest_y_index) {
            lowest_y_array[i] = true;
        }
        while (lowest_y_array[start_Point2D] == true) {
            start_Point2D = (start_Point2D + 1) % A.size();
        }
        start_Point2D = (start_Point2D - 1 + A.size()) % A.size();

        List<Point2D> rotated_A = new ArrayList<>(A.subList(start_Point2D, A.size()));
        rotated_A.addAll(A.subList(0, start_Point2D));

        int direction = _IsClockwise(rotated_A.get(rotated_A.size() - 1), rotated_A.get(0), rotated_A.get(1));
        List<Point2D> extended_A = new ArrayList<>(rotated_A);
        extended_A.addAll(rotated_A.subList(0, 2));
        for (int i = 0; i < A.size(); i++) {
            int temp = _IsClockwise(extended_A.get(i), extended_A.get(i + 1), extended_A.get(i + 2));
            if (temp * direction < 0) {
                return (i + 1 + start_Point2D) % A.size();
            }
        }

        return -1;
    }
}
