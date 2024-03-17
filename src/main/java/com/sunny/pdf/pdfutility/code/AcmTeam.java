package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class AcmTeam {

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        int n = topic.size();
        int maxTopicsKnown = 0;
        int maxTopicsTeamCount = 0;

        // Iterate over all pairs of attendees
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int topicsKnown = countTopics(topic.get(i), topic.get(j));

                // Update the maximum number of topics known and the count of teams knowing that number of topics
                if (topicsKnown > maxTopicsKnown) {
                    maxTopicsKnown = topicsKnown;
                    maxTopicsTeamCount = 1;
                } else if (topicsKnown == maxTopicsKnown) {
                    maxTopicsTeamCount++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(maxTopicsKnown);
        result.add(maxTopicsTeamCount);
        return result;

    }

    private static int countTopics(String topics1, String topics2) {
        int count = 0;
        for (int i = 0; i < topics1.length(); i++) {
            if (topics1.charAt(i) == '1' || topics2.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> topic = List.of(
                "10101",
                "11100",
                "11010",
                "00101"
        );
        List<Integer> result = acmTeam(topic);
        System.out.println("Maximum number of topics known: " + result.get(0));
        System.out.println("Number of teams knowing that number of topics: " + result.get(1));
    }
}
