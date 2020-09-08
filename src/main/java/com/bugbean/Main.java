package com.bugbean;

import java.util.*;

public class Main {
    /**
     * 该map表示题目中的推断结果
     */
    private static Map<String, Boolean> deduceResult = new HashMap<>();

    /**
     * 判断该rank是否吻合题意
     *
     * @param rank
     * @return
     */
    public static boolean anastomose(T rank) {
        String[] schoolRank = rank.getSchoolRank();
        //A说：E是第1名
        deduceResult.put("A", "E".equals(schoolRank[0]));
        //B说：B是第2名
        deduceResult.put("B", "B".equals(schoolRank[1]));
        //C说：A是第5名
        deduceResult.put("C", "A".equals(schoolRank[4]));
        //D说：C不是第1名
        deduceResult.put("D", !"C".equals(schoolRank[0]));
        //E说：D是第1名
        deduceResult.put("E", "D".equals(schoolRank[0]));

        //结果只有第一名和第二名的学校猜对
        //这里取出第一名和第二名的学校，如果结果是false，则证明此rank不符合题意
        if (!deduceResult.get(schoolRank[0]) || !deduceResult.get(schoolRank[1])) {
            return false;
        }

        //不是1、2名的学校都猜错了
        return !deduceResult.get(schoolRank[2]) && !deduceResult.get(schoolRank[3]) && !deduceResult.get(schoolRank[4]);

    }

    /**
     * 全排列
     * 递推公式：假设f(n)表示对n个元素全排列，则f(n)=f(1)+f(n-1),n>1
     *
     * @return
     */
    public static List<T> permutation(List<String> schools, int index) {
        List<T> result = new ArrayList<>();
        if (schools.size() == 0) {
            T rank = new T(5);
            result.add(rank);
            return result;
        }
        for (String school : schools) {
            List<String> newSchools = new ArrayList<>(schools);
            newSchools.remove(school);

            List<T> list = permutation(newSchools, index + 1);
            for (T t : list) {
                t.getSchoolRank()[index] = school;
            }
            result.addAll(list);
        }
        return result;

    }

    public static void main(String[] args) {
        List<T> results = new ArrayList<T>();
        List<String> schools = new ArrayList<>();
        schools.add("A");
        schools.add("B");
        schools.add("C");
        schools.add("D");
        schools.add("E");

        List<T> ranks = permutation(schools, 0);
        System.out.println(ranks);
        for (T rank : ranks) {
            if (!anastomose(rank)) {
                continue;
            }
            results.add(rank);
        }

        System.out.println("============================================");
        System.out.println(results);
    }

}

class T {
    /**
     * 学校排名
     * 数组下标代表排名，值表示学校
     */
    private String[] schoolRank;

    public String[] getSchoolRank() {
        return schoolRank;
    }

    public T(int size) {
        this.schoolRank = new String[size];
    }

    @Override
    public String toString() {
        return Arrays.toString(schoolRank);
    }
}
