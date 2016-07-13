package com.kd.ds;

class Stack{
    private int top;
    private int size;
    private int[] arr;
    
    Stack(int size){
        this.size = size;
        top = -1;
        arr = new int[size];
    }
    
    public boolean isEmpty(){
        return (top==-1);
    }
    
    public boolean isFull(){
        return (top==size-1);
    }
    
    public void push(int i){
        if(isFull()){
            System.out.println("\nStack is Full");
            return;
        }
        arr[++top]=i;
    }
    
    public int pop(){
        if(isEmpty()){
            System.out.println("\nStack is Empty");
            return Integer.MIN_VALUE;
        }
        return arr[top--];
    }
    
    public void printNextGreater(int[] arr,int n){
        int i=0,element=0,next=0;
        
        push(arr[0]);
        for(i=0 ; i<n ; i++){
            next = arr[i];
            
            if(!isEmpty()){
                element = pop();
                
                while(element<next){
                    System.out.println(element + " --> " + next);
                    if(isEmpty())
                        break;
                    element = pop();
                }
                if(element>next)
                    push(element);
            }
            push(next);
        }
        while(!isEmpty()){
            element = pop();
            next = -1;
            System.out.println(element + " --> " +next);
        }
    }
    
    public static void main(String[] args){
        int[] arr = {26,41,21,20,23,47,56,12,10,78,5};
        Stack stack = new Stack(arr.length);
        stack.printNextGreater(arr,arr.length);
    }
}
