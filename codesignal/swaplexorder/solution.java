/**
 * Author: Grant Nasution
 * Codesignal Hashtable Practice SwapLexOrder
 * Given a string str and array of pairs that indicates which indices in the string can be swapped, 
 * return the lexicographically largest string that results from doing the allowed swaps. 
 * You can swap indices any number of times.
 */

String swapLexOrder(String str, int[][] pairs) {
    String result = str;
    char[] arr = str.toCharArray();
    Hashtable<Integer, HashSet<Integer>> maps = new Hashtable<Integer, HashSet<Integer>>();
    ArrayList<Integer> firstIndices = new ArrayList<Integer>();
    for (int[] pair : pairs) {
        firstIndices.add(pair[0]);
    }
    
    //Find all routes between indices
    for(int[] pair : pairs) {
        HashSet<Integer> routes = maps.get(pair[0]);
        
        //If route doesnt exist create one
        if(routes == null) {
            routes = new HashSet<Integer>();
        } 
        //Pair indices are 1 - str.len inclusive
        routes.add(pair[0] - 1);
        routes.add(pair[1] - 1);
        maps.put(pair[0], routes);
    }
    
    //Join all connected routes
    if(pairs.length <= 1) {
        
    } else {
        for(int i = 0; i < firstIndices.size(); ++i) {
            HashSet<Integer> routeI = maps.get(firstIndices.get(i));
            for(int j = i + 1; j < firstIndices.size(); ++j) {
                HashSet<Integer> routeJ = maps.get(firstIndices.get(j));
                boolean match = false;
                //Check if there routes are connected
                for(Integer index : routeJ) {
                    if(routeI.contains(index)) {
                        match = true;
                        break;
                    }
                }
                //Join routes if they are
                if(match) {
                    for(Integer index : routeJ) {
                        routeI.add(index);
                    }
                    //Update routes and delete merged route
                    maps.put(firstIndices.get(i), routeI);
                    maps.remove(firstIndices.get(j));
                    firstIndices.remove(firstIndices.get(j));
                }
            }
        }
    }   
    //Swap letters
    for(int i = 0; i < firstIndices.size(); ++i) {
        result = greatestLex(result, maps.get(firstIndices.get(i)));
    }
    return result;
}

String greatestLex(String str, HashSet<Integer> indices) {
    String result = "";
    char[] arr = str.toCharArray();
    Hashtable<Character, Integer> letters = new Hashtable<Character, Integer>();
    char[] alphabet = new char[26];
    //Reverse alphabet
    for(int i = 0; i < 26 ; ++i) {
        alphabet[i] = (char)('z' - i);
    }
    ArrayList<Integer> indexes = new ArrayList<Integer>();
    for(Integer i : indices) {
        indexes.add(i);
    }
    
    
    for(Integer i : indices) {
        Integer temp = letters.get(i);
        if(temp == null) {
            letters.put(arr[i], 1);
        } else {
            letters.put(arr[i], temp + 1);
        }
    }
    
    int i = 0;
    for(Character ch : alphabet) {
        Integer count = letters.get(ch);
        if(count != null) {
            while(count > 0) {
            //Replace next index with next largest letter and increment
            arr[indexes.get(i)] = ch;
            i += 1;           
            //Decrement and update
            count -= 1;
            letters.put(ch, count);
            }
        }
    }    
    result = String.valueOf(arr);
    
    return result;
}
