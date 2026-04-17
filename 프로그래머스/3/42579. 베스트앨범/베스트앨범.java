import java.util.*;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (!map.containsKey(genre)) {
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i, plays[i]});
                map.put(genre, list);
            } else {
                map.get(genre).add(new int[]{i, plays[i]});
            }
        }
        
        Map<String, Integer> gmap = new HashMap<>();
        for (String genre : map.keySet()) {
            int total = 0;
            for (int[] song : map.get(genre)) {
                total += song[1];
            }
            gmap.put(genre, total);
        }
        
        List<String> sortedGenres = new ArrayList<>(gmap.keySet());
        sortedGenres.sort((a, b) -> gmap.get(b) - gmap.get(a));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = map.get(genre);
            songs.sort((a, b) -> b[1] - a[1]);
            
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}