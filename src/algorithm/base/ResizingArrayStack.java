package algorithm.base;

import java.util.Iterator;

/**
 * @author 潇潇暮雨
 * @create 2018-09-04   20:38
 *
 * 实现了一个简易的栈,此处是用数组实现，也可以用链表实现
 */
public class ResizingArrayStack<T> implements Iterable<T>{
    // 栈元素
    private T[] table;
    // 元素数量
    private int size;

    public ResizingArrayStack() {
        // 初始化时给数组默认大小为10
        table = (T[]) new Object[10];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    // resize(),将栈移动到一个大小为max的数组
    public void resize(int max){
        T[] newTable = (T[])new Object[max];
        for (int i = 0; i < size; i++) {
            newTable[i] = table[i];
        }
        table = newTable;

    }
    // push(Integer str) 将元素添加到栈顶
    public void push(T t){
        if (size == table.length)
            resize(2 * size);
        table[size++] = t;
    }
    // pop() 返回值为int   从栈顶删除元素
    public T pop(){
       T i =  table[--size];
        table[size] =null;
        return i;
    }

    @Override
    public Iterator<T> iterator() {

        return null;
    }

}
