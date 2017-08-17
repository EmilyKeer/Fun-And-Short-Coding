/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example
Given n = 2, prerequisites = [[1,0]]
Return [0,1]

Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
Return [0,1,2,3] or [0,2,1,3]


*/

/*
1. int[] degree: how many prerequisites required
List[] ableCourses: enable(maybe partly) courses for each course; ArrayList<Integer>
2. go through courses with degree[i] == 0
    for each course: check ableCourses degree
    
    
Note:
create array with capacity:
int[] array = new int[capacity];
for(int i=0; i<capacity; i++) {
    array[i] = ...;
}
*/
public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            //return an order
            int[] order = new int[numCourses];
            for (int i=0; i<numCourses; i++) {
                order[i] = i;
            }
            return order;
        }
        int[] degree = new int[numCourses]; //initial 0
        List[] ableCourses = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            ableCourses[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            ableCourses[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue queue = new LinkedList();
        int[] order = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int course = (int)queue.poll(); //Integer
            order[count] = course;
            count++;
            for (int i=ableCourses[course].size()-1; i>=0; i--) {
                int preCourse = (int)ableCourses[course].get(i);
                degree[preCourse]--;
                if (degree[preCourse] == 0) {
                    queue.offer(preCourse);
                }
            }
            
        }
        if (count == numCourses) {
            return order;
        } else {
            return new int[0]; //empty array
        }
    }
}