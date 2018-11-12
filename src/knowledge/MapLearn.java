package knowledge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class MapLearn {
    static class A
    {
        int count;
        public A(int count)
        {
            this.count = count;
        }
        //根据count的值来判断两个对象是否相等。
        public boolean equals(Object obj)
        {
            if (obj == this)
                return true;
            if (obj!=null &&
                    obj.getClass()==A.class)
            {
                A a = (A)obj;
                return this.count == a.count;
            }
            return false;
        }
        //根据count来计算hashCode值。
        public int hashCode()
        {
            return this.count;
        }
    }
    static class B
    {
        //重写equals()方法，B对象与任何对象通过equals()方法比较都相等
        public boolean equals(Object obj)
        {
            return true;
        }
    }
    public static class HashtableTest
    {
        public static void main(String[] args)
        {
            Hashtable ht = new Hashtable();
            ht.put(new A(60000) , "疯狂Java讲义");
            ht.put(new A(87563) , "轻量级Java EE企业应用实战");
            ht.put(new A(1232) , new B());
            System.out.println(ht);

            //只要两个对象通过equals比较返回true，
            //Hashtable就认为它们是相等的value。
            //由于Hashtable中有一个B对象，
            //它与任何对象通过equals比较都相等，所以下面输出true。
            System.out.println(ht.containsValue("测试字符串"));  //①

            //只要两个A对象的count相等，它们通过equals比较返回true，且hashCode相等
            //Hashtable即认为它们是相同的key，所以下面输出true。
            System.out.println(ht.containsKey(new A(87563)));   //②

            //下面语句可以删除最后一个key-value对
            ht.remove(new A(1232));    //③

            //通过返回Hashtable的所有key组成的Set集合，
            //从而遍历Hashtable每个key-value对
            for (Object key : ht.keySet())
            {
                System.out.print(key + "---->");
                System.out.print(ht.get(key) + "\n");
            }
        }
    }

    public static class LinkedHashMapTest
    {
        public static void main(String[] args)
        {
            LinkedHashMap scores = new LinkedHashMap();
            scores.put("语文" , 80);
            scores.put("英文" , 82);
            scores.put("数学" , 76);
            //遍历scores里的所有的key-value对
            for (Object key : scores.keySet())
            {
                System.out.println(key + "------>" + scores.get(key));
            }
        }
    }

    public static class PropertiesTest
    {
        public static void main(String[] args) throws Exception
        {
            Properties props = new Properties();
            //向Properties中增加属性
            props.setProperty("username" , "yeeku");
            props.setProperty("password" , "123456");

            //将Properties中的key-value对保存到a.ini文件中
            props.store(new FileOutputStream("a.ini"), "comment line");   //①

            //新建一个Properties对象
            Properties props2 = new Properties();
            //向Properties中增加属性
            props2.setProperty("gender" , "male");

            //将a.ini文件中的key-value对追加到props2中
            props2.load(new FileInputStream("a.ini") );    //②
            System.out.println(props2);
        }
    }

    static class R implements Comparable
    {
        int count;
        public R(int count)
        {
            this.count = count;
        }
        public String toString()
        {
            return "R[count:" + count + "]";
        }
        //根据count来判断两个对象是否相等。
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj!=null
                    && obj.getClass()==R.class)
            {
                R r = (R)obj;
                return r.count == this.count;
            }
            return false;
        }
        //根据count属性值来判断两个对象的大小。
        public int compareTo(Object obj)
        {
            R r = (R)obj;
            return count > r.count ? 1 :
                    count < r.count ? -1 : 0;
        }
    }
    public static class TreeMapTest
    {
        public static void main(String[] args)
        {
            TreeMap tm = new TreeMap();
            tm.put(new R(3) , "轻量级Java EE企业应用实战");
            tm.put(new R(-5) , "疯狂Java讲义");
            tm.put(new R(9) , "疯狂Android讲义");

            System.out.println(tm);

            //返回该TreeMap的第一个Entry对象
            System.out.println(tm.firstEntry());

            //返回该TreeMap的最后一个key值
            System.out.println(tm.lastKey());

            //返回该TreeMap的比new R(2)大的最小key值。
            System.out.println(tm.higherKey(new R(2)));

            //返回该TreeMap的比new R(2)小的最大的key-value对。
            System.out.println(tm.lowerEntry(new R(2)));

            //返回该TreeMap的子TreeMap
            System.out.println(tm.subMap(new R(-1) , new R(4)));
        }
    }


    public static class WeakHashMapTest
    {
        public static void main(String[] args)
        {
            WeakHashMap whm = new WeakHashMap();
            //将WeakHashMap中添加三个key-value对，
            //三个key都是匿名字符串对象（没有其他引用）
            whm.put(new String("语文") , new String("良好"));
            whm.put(new String("数学") , new String("及格"));
            whm.put(new String("英文") , new String("中等"));

            //将WeakHashMap中添加一个key-value对，
            //该key是一个系统缓存的字符串对象。"java"是一个常量字符串强引用
            whm.put("java" , new String("中等"));
            //输出whm对象，将看到4个key-value对。
            System.out.println(whm);
            //通知系统立即进行垃圾回收
            System.gc();
            System.runFinalization();
            //通常情况下，将只看到一个key-value对。
            System.out.println(whm);
        }
    }

    public static class IdentityHashMapTest
    {
        public static void main(String[] args)
        {
            IdentityHashMap ihm = new IdentityHashMap();
            //下面两行代码将会向IdentityHashMap对象中添加两个key-value对
            ihm.put(new String("语文") , 89);
            ihm.put(new String("语文") , 78);

            //下面两行代码只会向IdentityHashMap对象中添加一个key-value对
            ihm.put("java" , 93);
            ihm.put("java" , 98);
            System.out.println(ihm);
        }
    }

    enum Season
    {
        SPRING,SUMMER,FALL,WINTER
    }
    public static class EnumMapTest
    {
        public static void main(String[] args)
        {
            //创建一个EnumMap对象，该EnumMap的所有key
            //必须是Season枚举类的枚举值
            EnumMap enumMap = new EnumMap(Season.class);
            enumMap.put(Season.SUMMER , "夏日炎炎");
            enumMap.put(Season.SPRING , "春暖花开");
            System.out.println(enumMap);
        }
    }
}
