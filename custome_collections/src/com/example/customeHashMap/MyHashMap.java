package com.example.customeHashMap;


//Note : I am keeping it simple for understanding purpose. This is not a exact same code as java.util.HashMap. But concept is same.
public class MyHashMap {

	int bucketSize;
	Entery[] table ;
	int elementCount=0 ;
	class Entery {
		int key;
		int value;
		Entery next;
		Entery(int key, int value, Entery next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	
	MyHashMap() {
		bucketSize = 16; // default size 
		table = new Entery[bucketSize];
	}
	
	public int put(int key , int value) {
		
	int index=calculateIndex(key);
	System.out.println("Index is : "+index);
		
	    Entery current = table[index];
	    if(current == null) {
	    	resizingIfRequired();
	    	current = new Entery(key,value,null);
	    	table[index] = current;
	    	elementCount++;
	    }else {// creating else as placehoder i case if  u want to write code of collision and implement Link list / BalancedTree
	    	// it means already some value is present at key
	    	//resizingIfRequired();
	    	current = new Entery(key,value,null);
	    	table[index] = current; // just replacing the value
	    	//elementCount++;
	    }
		return value;
	}

	private void resizingIfRequired() {
		if (elementCount >= bucketSize * .75) { // load factor is .75 in java.util.HashMap
			System.out.println("Resizing happened at elementCount :  "+elementCount + "BucketSize : "+bucketSize);
			Entery[] newTable = new Entery[bucketSize * 2];

			for (int i = 0; i < table.length; i++) {
				newTable[i] = table[i];
			}
			this.table = newTable;
			this.bucketSize= 2*bucketSize;

		}else {
			System.out.println("Resizing did not happened ");
		}

	}

	private int calculateIndex(Integer key) {

		//=========================Just to read and explan in interview=============
		/*
		int newHash = key.hashCode()>>>1;  // just shifting hascode bit by 16 bit left. Same way used in java.util.HashMap
		//int index = newHash % bucketSize; // this was also can be used but  & is efficient than %.
		int index = newHash & (bucketSize - 1); // this is the way java.util.HashMap calculate index.
		return index;	
		*/
		
		// just for simple implementation........
		return key % (bucketSize-1);
	} 
	
	public int get(int key) {
		int index = calculateIndex(key);
		Entery entery=table[index];
		if(entery==null) { 
			return -1; // Lets assume -1 is default  value at all the index of table
		}
		return table[index].value;
	}
	
	public static void main(String[] args) {
		System.out.println("Hiiii");
		MyHashMap map = new MyHashMap();
		map.put(0,1);
		map.put(1,1);
		map.put(2,2);
		map.put(3,4);
		map.put(5,5);
		map.put(6,6);
		map.put(7,7);
		map.put(8,8);
		map.put(9,9);
		
		map.put(10,10);
		map.put(11,11);
		map.put(12,12);
		map.put(13,13);
		map.put(14,14);
		map.put(15,15);
		
		System.out.println("Map get is : "+map.get(14));
		
	}
}
