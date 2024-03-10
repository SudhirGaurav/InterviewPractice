package com.example.LRUcache.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


//LRU COncept : https://www.geeksforgeeks.org/lru-cache-implementation/
class LRUCache_UsingCache{
	// Concept : The idea is to keep the keys on the Map for quick access to data within the Stack.
	Stack<String> stack; // this is used for add cache value at index
	Map<String, String> cacheMap ; // used to store value in cache
	public int CACHE_MAX_SIZE=0;

	LRUCache_UsingCache(int size) {
		this.CACHE_MAX_SIZE = size;
		stack= new Stack<>();
		cacheMap = new HashMap<>();
	}
	
	public boolean addIntoCache(String key, String value) {
		if (stack.size() >= CACHE_MAX_SIZE) {
			String leastUsedElement= stack.remove(0); //Remove bottom one because it is least used [LRU Cache]
			cacheMap.remove(leastUsedElement); // Remove from cache
		}
		stack.push(key);
		cacheMap.put(key, value);
		return true;
	}
	
	public String getValueFromCache(String key) { // Need to keep this object at top , because is most used Object [LRU Concept ]
		if(!stack.isEmpty() && !stack.contains(key)) {
			return "Vlaue is not availabe in cache";
		}
		String retValue = cacheMap.get(key);
		int mostUsedIndex = stack.indexOf(key);
		if(!(mostUsedIndex == (CACHE_MAX_SIZE -1 ))) {
			stack.remove(key);
			stack.push(key);
		}
		return retValue;
	}

	public void printCacheAndStack() {

		System.out.println("Stack is : "+stack);
		System.out.println("Cache is : "+cacheMap);
		System.out.println("Index of 1: "+stack.indexOf("1"));
	}
	
	
}
public class MainDriverClass {

	public static void main(String[] args) {
		LRUCache_UsingCache lruCache = new LRUCache_UsingCache(3);
		lruCache.addIntoCache("1", "Sudhir");
		lruCache.addIntoCache("2", "Sudhir");
		lruCache.addIntoCache("3", "Sudhir");
		
		lruCache.addIntoCache("5", "Sudhir");
		lruCache.printCacheAndStack();
		System.out.println("Getting value of 1 "+lruCache.getValueFromCache("3"));
		lruCache.printCacheAndStack();

	}

}
