package knowledge;

import java.util.*;

public class CollectionLearn {
    //类A的equals方法总是返回true,但没有重写其hashCode()方法。不能保证当前对象是HashSet中的唯一对象
    static class A
    {
        public boolean equals(Object obj)
        {
            return true;
        }
    }

    //类B的hashCode()方法总是返回1,但没有重写其equals()方法。不能保证当前对象是HashSet中的唯一对象
    static class B
    {
        public int hashCode()
        {
            return 1;
        }
    }

    //类C的hashCode()方法总是返回2,且有重写其equals()方法
    static class C
    {
        public int hashCode()
        {
            return 2;
        }
        public boolean equals(Object obj)
        {
            return true;
        }
    }
    public static class HashSetTest
    {
        public static void main(String[] args)
        {
            HashSet books = new HashSet();
            //分别向books集合中添加两个A对象，两个B对象，两个C对象
            books.add(new A());
            books.add(new A());

            books.add(new B());
            books.add(new B());

            books.add(new C());
            books.add(new C());
            System.out.println(books);
            //[B@1, B@1, C@2, A@3bc257, A@785d65]
        }
    }
    public static class LinkedHashSetTest
    {
        public static void main(String[] args)
        {
            LinkedHashSet books = new LinkedHashSet();
            books.add("Java");
            books.add("LittleHann");
            System.out.println(books);

            //删除 Java
            books.remove("Java");
            //重新添加 Java
            books.add("Java");
            System.out.println(books);
            //[Java, LittleHann]
            //[LittleHann, Java]
            //元素的顺序总是与添加顺序一致，同时要明白的是，LinkedHashSetTest是HashSet的子类，因此它不允许集合元素重复
        }
    }
    public static class TreeSetTest
    {
        public static void main(String[] args)
        {
            TreeSet nums = new TreeSet();
            //向TreeSet中添加四个Integer对象
            nums.add(5);
            nums.add(2);
            nums.add(10);
            nums.add(-9);

            //输出集合元素，看到集合元素已经处于排序状态
            System.out.println(nums);

            //输出集合里的第一个元素
            System.out.println(nums.first());

            //输出集合里的最后一个元素
            System.out.println(nums.last());

            //返回小于4的子集，不包含4
            System.out.println(nums.headSet(4));

            //返回大于5的子集，如果Set中包含5，子集中还包含5
            System.out.println(nums.tailSet(5));

            //返回大于等于-3，小于4的子集。
            System.out.println(nums.subSet(-3 , 4));
        }
        //与HashSet集合采用hash算法来决定元素的存储位置不同，TreeSet采用红黑树的数据结构来存储集合元素。
    }
    static class M
    {
        int age;
        public M(int age)
        {
            this.age = age;
        }
        public String toString()
        {
            return "M[age:" + age + "]";
        }
    }

    public static class TreeSetTest4
    {
        public static void main(String[] args)
        {
            TreeSet ts = new TreeSet(new Comparator()
            {
                //根据M对象的age属性来决定大小
                public int compare(Object o1, Object o2)
                {
                    M m1 = (M)o1;
                    M m2 = (M)o2;
                    return m1.age > m2.age ? -1
                            : m1.age < m2.age ? 1 : 0;
                }
            });
            ts.add(new M(5));
            ts.add(new M(-3));
            ts.add(new M(9));
            System.out.println(ts);
        }
    }
    //1) equals、compareTo决定的是怎么比的问题，即用什么field进行大小比较
    //2) 自然排序、定制排序、Comparator决定的是谁大的问题，即按什么顺序(升序、降序)进行排序
    //它们的关注点是不同的，一定要注意区分
    public static class ListTest {
        public static void main(String[] args) {
            List books = new ArrayList();
            //向books集合中添加三个元素
            books.add(new String("轻量级Java EE企业应用实战"));
            books.add(new String("疯狂Java讲义"));
            books.add(new String("疯狂Android讲义"));
            System.out.println(books);

            //将新字符串对象插入在第二个位置
            books.add(1, new String("疯狂Ajax讲义"));
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books.get(i));
            }

            //删除第三个元素
            books.remove(2);
            System.out.println(books);

            //判断指定元素在List集合中位置：输出1，表明位于第二位
            System.out.println(books.indexOf(new String("疯狂Ajax讲义")));  //①
            //将第二个元素替换成新的字符串对象
            books.set(1, new String("LittleHann"));
            System.out.println(books);

            //将books集合的第二个元素（包括）
            //到第三个元素（不包括）截取成子集合
            System.out.println(books.subList(1, 2));
        }
    }
    public static class StackTest
    {
        public static void main(String[] args)
        {
            Stack v = new Stack();
            //依次将三个元素push入"栈"
            v.push("疯狂Java讲义");
            v.push("轻量级Java EE企业应用实战");
            v.push("疯狂Android讲义");

            //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
            System.out.println(v);

            //访问第一个元素，但并不将其pop出"栈"，输出：疯狂Android讲义
            System.out.println(v.peek());

            //依然输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
            System.out.println(v);

            //pop出第一个元素，输出：疯狂Android讲义
            System.out.println(v.pop());

            //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战]
            System.out.println(v);
        }
    }

    public static class LinkedListTest
    {
        public static void main(String[] args)
        {
            LinkedList books = new LinkedList();

            //将字符串元素加入队列的尾部(双端队列)
            books.offer("疯狂Java讲义");

            //将一个字符串元素加入栈的顶部(双端队列)
            books.push("轻量级Java EE企业应用实战");

            //将字符串元素添加到队列的头(相当于栈的顶部)
            books.offerFirst("疯狂Android讲义");

            for (int i = 0; i < books.size() ; i++ )
            {
                System.out.println(books.get(i));
            }

            //访问、并不删除栈顶的元素
            System.out.println(books.peekFirst());
            //访问、并不删除队列的最后一个元素
            System.out.println(books.peekLast());
            //将栈顶的元素弹出"栈"
            System.out.println(books.pop());
            //下面输出将看到队列中第一个元素被删除
            System.out.println(books);
            //访问、并删除队列的最后一个元素
            System.out.println(books.pollLast());
            //下面输出将看到队列中只剩下中间一个元素：
            //轻量级Java EE企业应用实战
            System.out.println(books);
        }
    }

    public static class PriorityQueueTest
    {
        public static void main(String[] args)
        {
            PriorityQueue pq = new PriorityQueue();
            //下面代码依次向pq中加入四个元素
            pq.offer(6);
            pq.offer(-3);
            pq.offer(9);
            pq.offer(0);

            //输出pq队列，并不是按元素的加入顺序排列，
            //而是按元素的大小顺序排列，输出[-3, 0, 9, 6]
            System.out.println(pq);
            //访问队列第一个元素，其实就是队列中最小的元素：-3
            System.out.println(pq.poll());
        }
    }

    public static class ArrayDequeTest
    {
        public static void main(String[] args)
        {
            ArrayDeque stack = new ArrayDeque();
            //依次将三个元素push入"栈"
            stack.push("疯狂Java讲义");
            stack.push("轻量级Java EE企业应用实战");
            stack.push("疯狂Android讲义");

            //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
            System.out.println(stack);

            //访问第一个元素，但并不将其pop出"栈"，输出：疯狂Android讲义
            System.out.println(stack.peek());

            //依然输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
            System.out.println(stack);

            //pop出第一个元素，输出：疯狂Android讲义
            System.out.println(stack.pop());

            //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战]
            System.out.println(stack);
        }
    }

    public static class IteratorTest
    {
        public static void main(String[] args)
        {
            //创建一个集合
            Collection books = new HashSet();
            books.add("轻量级Java EE企业应用实战");
            books.add("疯狂Java讲义");
            books.add("疯狂Android讲义");


            //获取books集合对应的迭代器
            Iterator it = books.iterator();
            while(it.hasNext())
            {
                //it.next()方法返回的数据类型是Object类型，
                //需要强制类型转换
                String book = (String)it.next();
                System.out.println(book);
                if (book.equals("疯狂Java讲义"))
                {
                    //从集合中删除上一次next方法返回的元素
                    it.remove();
                }
                //对book变量赋值，不会改变集合元素本身
                book = "测试字符串";
            }
            System.out.println(books);
        }
    }

    public static class ForeachTest
    {
        public static void main(String[] args)
        {
            //创建一个集合
            Collection books = new HashSet();
            books.add(new String("轻量级Java EE企业应用实战"));
            books.add(new String("疯狂Java讲义"));
            books.add(new String("疯狂Android讲义"));

            for (Object obj : books)
            {
                //此处的book变量也不是集合元素本身
                String book = (String)obj;
                System.out.println(book);
                if (book.equals("疯狂Android讲义"))
                {
                    //下面代码会引发ConcurrentModificationException异常
                    //books.remove(book);
                }
            }
            System.out.println(books);
        }
    }

    public static class ListIteratorTest
    {
        public static void main(String[] args)
        {
            String[] books = {
                    "疯狂Java讲义",
                    "轻量级Java EE企业应用实战"
            };
            List bookList = new ArrayList();
            for (int i = 0; i < books.length ; i++ )
            {
                bookList.add(books[i]);
            }
            ListIterator lit = bookList.listIterator();
            while (lit.hasNext())
            {
                System.out.println(lit.next());
                lit.add("-------分隔符-------");
            }
            System.out.println("=======下面开始反向迭代=======");
            while(lit.hasPrevious())
            {
                System.out.println(lit.previous());
            }
        }
    }


}
