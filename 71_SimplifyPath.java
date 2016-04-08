public class Solution {
    public String simplifyPath(String path) {
        // 1. String!
        String[] temp = path.split("/");
        String[] stack = new String[temp.length];
        int count = 0;
        int len = temp.length;
        for (int i = 0; i < len; ++i) {
            if (temp[i].equals(".") || temp[i].equals("")) {
                continue;
            } else if (temp[i].equals("..")) {
                if (count > 0) count--;
            } else {
                stack[count] = temp[i];
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("/" + stack[i]);
        }
        return sb.length() == 0 ? "/" : sb.toString();
        
        // 2. Using queue
        // String[] temp = path.split("/");
        // LinkedList<String> queue = new LinkedList<>();
        // for (int i = 0; i < temp.length; i++) {
        //     if (temp[i].equals(".") || temp[i].equals("")) {
        //         continue;
        //     } else if (temp[i].equals("..")) {
        //         if (queue.size() > 0) queue.removeLast();
        //     } else {
        //         queue.add(temp[i]);
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // while (queue.size() > 0) {
        //     sb.append("/");
        //     sb.append(queue.poll());
        // }
        // return sb.length() == 0 ? "/" : sb.toString();
    }
}
