
public class Homwork2 {

 public static void main(String args[])
 {
System.out.println();
System.out.println();
System.out.println();

   DateTime dt1 = new DateTime(); // "now"
   System.out.println("now = " + dt1); // â€œmm/dd/yyyy, hh:mm:ssâ€?.
   
   DateTime dt2 = new DateTime(2000, 1, 2, 3, 4, 5);
   System.out.println("DateTime constructor test 2000, 1(January), 2, 3, 4, 5 = "  + dt2); 
 if( dt2.getYear()!=2000 || dt2.getMonth()!=1 || dt2.getDay()!=2 || dt2.getHour()!=3 || dt2.getMinute()!=4 || dt2.getSecond()!=5 )
     System.out.println("using get.. WRONG" ); 
 
 System.out.println(dt2.getYear());
 System.out.println(dt2.getMonth());
 System.out.println(dt2.getDay());
 System.out.println(dt2.getHour());
 System.out.println(dt2.getMinute());
  
System.out.println();

   Time t1 = new Time( 1,1,1,1);  //d, h, m, s
   System.out.println("Time constructor test 1,1,1,1 = " + t1);
if(  t1.getDays()!=1 || t1.getHours()!=1 || t1.getMinutes()!=1 || t1.getSeconds()!=1 )
   System.out.println("using get.. WRONG");

System.out.println();

   DateTime dt12 = dt2.add(t1);
 if( dt12.getYear()!=2000 || dt12.getMonth()!=1 || dt12.getDay()!=3 || dt12.getHour()!=4 || dt12.getMinute()!=5 || dt12.getSecond()!=6 )
     System.out.println("add WRONG" );
  // else System.out.println("add true" );

   if( dt2.getYear()!=2000 || dt2.getMonth()!=1 || dt2.getDay()!=2 || dt2.getHour()!=3 || dt2.getMinute()!=4 || dt2.getSecond()!=5 )
     System.out.println("add NOT immutable" );
   //else System.out.println("add immutable" );

System.out.println();

   dt2 = new DateTime(2000, 1, 2, 3, 4, 5);
   DateTime dt4 = dt2.subtract(t1);
 if( dt4.getYear()!=2000 || dt4.getMonth()!=1 || dt4.getDay()!=1 || dt4.getHour()!=2 || dt4.getMinute()!=3 || dt4.getSecond()!=4 )
     System.out.println("subtract WRONG" );
  // else System.out.println("subtract true" );

 if( dt2.getYear()!=2000 || dt2.getMonth()!=1 || dt2.getDay()!=2 || dt2.getHour()!=3 || dt2.getMinute()!=4 || dt2.getSecond()!=5 )
     System.out.println("subtract NOT immutable" );
  // else System.out.println("subtract immutable" );

System.out.println();

   dt2 = new DateTime(2000, 1, 2, 3, 4, 5);
   DateTime dt3 = new DateTime(2000, 1, 3, 2, 4, 4);
   Time t23 = dt3.subtract(dt2);
  if(  t23.getDays()!=0 || t23.getHours()!=22 || t23.getMinutes()!=59 || t23.getSeconds()!=59 )
    System.out.println("Time interval WRONG" );
  // else System.out.println("Time interval true" );

    if( dt2.getYear()!=2000 || dt2.getMonth()!=1 || dt2.getDay()!=2 || dt2.getHour()!=3 || dt2.getMinute()!=4 || dt2.getSecond()!=5 )
     System.out.println("interval NOT immutable" );
  // else System.out.println("interval immutable" );
if( dt3.getYear()!=2000 || dt3.getMonth()!=1 || dt3.getDay()!=3 || dt3.getHour()!=2 || dt3.getMinute()!=4 || dt3.getSecond()!=4 )
     System.out.println("interval NOT immutable" );
  // else System.out.println("interval immutable" );

System.out.println();

   t1 = new Time( 1,1,1,1);
   Time t2 = new Time( 1,23,1,59);  //d, h, m, s
   Time tadd = t1.add(t2);
   System.out.println("Time add; 3:0:3:0 = " + tadd); 
  if( tadd == null ||  tadd.getDays()!=3 || tadd.getHours()!=0 || tadd.getMinutes()!=3 || tadd.getSeconds()!=0 )
    System.out.println("Time add WRONG" );
 //  else System.out.println("Time add true" );
 
  if(  t1.getDays()!=1 || t1.getHours()!=1 || t1.getMinutes()!=1 || t1.getSeconds()!=1 )
     System.out.println("time add NOT immutable " + t1 );
 //  else System.out.println("time add immutable" );
 if(  t2.getDays()!=1 || t2.getHours()!=23 || t2.getMinutes()!=1 || t2.getSeconds()!=59 )
     System.out.println("time add NOT immutable " + t2 );
 //  else System.out.println("time add immutable" );

System.out.println();

   t1 = new Time( 1,1,1,1); 
   t2 = new Time( 1,23,1,59); 
   Time ts = t2.subtract(t1);
   System.out.println("Time subtract; 0:22:0:58 = " + ts ); // 0:22:0:58
 if( ts == null ||  ts.getDays()!=0 || ts.getHours()!=22 || ts.getMinutes()!=0 || ts.getSeconds()!=58 )
    System.out.println("Time subtract WRONG" );
  if(  t1.getDays()!=1 || t1.getHours()!=1 || t1.getMinutes()!=1 || t1.getSeconds()!=1 )
     System.out.println("time subtract NOT immutable " + t1  );
   //else System.out.println("time subtract immutable" );
 if(  t2.getDays()!=1 || t2.getHours()!=23 || t2.getMinutes()!=1 || t2.getSeconds()!=59 )
     System.out.println("time subtract NOT immutable " + t2 );
  // else System.out.println("time subtract immutable" );

System.out.println();

   t1 = new Time( 1,1,1,1); 
   t2 = new Time( 1,23,1,59); 
   ts = t1.subtract(t2);
   System.out.println("Time subtract neg; -0:22:0:58 = " + ts); // -0:22:0:58
  if(  t1.getDays()!=1 || t1.getHours()!=1 || t1.getMinutes()!=1 || t1.getSeconds()!=1 )
     System.out.println("time add NOT immutable " + t1  );
//   else System.out.println("time add immutable" );
 if(  t2.getDays()!=1 || t2.getHours()!=23 || t2.getMinutes()!=1 || t2.getSeconds()!=59 )
     System.out.println("time add NOT immutable "  + t2);
 //  else System.out.println("time add immutable" );

System.out.println();
System.out.println("-----leap year test---------");

   t1 = new Time( 1,0,0,0); 
   dt1 = new DateTime(2000, 2, 28, 0, 0, 0);
   dt2 = dt1.add(t1);
   System.out.println("2000, February, 29!!!, 0, 0, 0 = " + dt2); //2000, 2, 29!!!, 3, 4, 5
 if( dt2.getYear()!=2000 || dt2.getMonth()!=2 || dt2.getDay()!=29 )
     System.out.println("leap1 WRONG" ); 

   t1 = new Time( 1,0,0,0); 
   dt1 = new DateTime(2001, 2, 28, 0, 0, 0);
   dt2 = dt1.add(t1);
   System.out.println("2001, March, 1!!!, 0, 0, 0 = " + dt2); //2000, 2, 29!!!, 3, 4, 5
 if( dt2.getYear()!=2001 || dt2.getMonth()!=3 || dt2.getDay()!=1 )
     System.out.println("leap2 WRONG" ); 

   t1 = new Time( 1,0,0,0); 
   dt1 = new DateTime(1996, 3, 1, 0, 0, 0);
   dt2 = dt1.subtract(t1);
   System.out.println("1996, February, 29!!!, 0, 0, 0 = " + dt2); //2000, 2, 29!!!, 3, 4, 5
 if( dt2.getYear()!=1996 || dt2.getMonth()!=2 || dt2.getDay()!=29 )
     System.out.println("leap3 WRONG" ); 

System.out.println();
System.out.println("---------to test wrong constructor:----");

   t1 = new Time( 1,0,0,0); 
   dt1 = new DateTime(2000, 1, 28, 0, 0, 0);
   dt2 = dt1.add(t1);
   System.out.println(" 2000, February, 29!!!, 0, 0, 0 = " + dt2); //2000, 2, 29!!!, 3, 4, 5
 if( dt2.getYear()!=2000 || dt2.getMonth()!=1 || dt2.getDay()!=29 )
     System.out.println("leap1 WRONG" ); 

   t1 = new Time( 1,0,0,0); 
   dt1 = new DateTime(2001, 1, 28, 0, 0, 0);
   dt2 = dt1.add(t1);
   System.out.println("2001, March, 1!!!, 0, 0, 0 = " + dt2); //2000, 2, 29!!!, 3, 4, 5
 if( dt2.getYear()!=2001 || dt2.getMonth()!=2 || dt2.getDay()!=1 )
     System.out.println("leap2 WRONG" );

   t1 = new Time( 1,0,0,0); 
   dt1 = new DateTime(1996, 2, 1, 0, 0, 0);
   dt2 = dt1.subtract(t1);
   System.out.println("1996, February, 29!!!, 0, 0, 0 = " + dt2); //2000, 2, 29!!!, 3, 4, 5
 if( dt2.getYear()!=1996 || dt2.getMonth()!=1 || dt2.getDay()!=29 )
     System.out.println("leap3 WRONG" ); 

System.out.println();
System.out.println("-----------bonus part-----------");

//bonus
   dt1 = new DateTime(1582, 10, 10, 3, 4, 5);
   System.out.println("1582, 10, 10, 3, 4, 5 not exist " + dt1);
 if( dt1.getYear()!=1582 || dt1.getMonth()!=10 || dt1.getDay()!=20 )
     System.out.println("bonus1 WRONG" ); 
 
   t1 = new Time( 1,0,0,0); 
   dt1 = new DateTime(1582, 10, 4, 3, 4, 5);
   dt2 = dt1.add(t1);
   System.out.println("1582, 10, 15!!!, 3, 4, 5 = " + dt2);  //1582, 10, 15!!!, 3, 4, 5   5 points
 if( dt2.getYear()!=1582 || dt2.getMonth()!=10 || dt2.getDay()!=15 )
     System.out.println("bonus2 WRONG" ); 

   dt1 = new DateTime(2100, 2, 28, 3, 4, 5);
   dt2 = dt1.add(t1);
   System.out.println("2100, 3, 1!!!, 3, 4, 5 = " + dt2); //2100, 3, 1!!!, 3, 4, 5
 if( dt2.getYear()!=2100 || dt2.getMonth()!=3 || dt2.getDay()!=1 )
     System.out.println("bonus3 WRONG" ); 

System.out.println();
System.out.println("-----------bonus part to test wrong constructor:-----------");

//bonus
   dt1 = new DateTime(1582, 9, 10, 3, 4, 5);
   System.out.println("1582, 9, 10, 3, 4, 5 not exist " + dt1);
  if( dt1.getYear()!=1582 || dt1.getMonth()!=9 || dt1.getDay()!=20 )
     System.out.println("bonus1 WRONG" ); 

   t1 = new Time( 1,0,0,0); 
   dt1 = new DateTime(1582, 9, 4, 3, 4, 5);
   dt2 = dt1.add(t1);
   System.out.println("1582, 9, 15!!!, 3, 4, 5 = " + dt2);  //1582, 10, 15!!!, 3, 4, 5   5 points
   if( dt2.getYear()!=1582 || dt2.getMonth()!=9 || dt2.getDay()!=15 )
     System.out.println("bonus2 WRONG" ); 

   dt1 = new DateTime(2100, 1, 28, 3, 4, 5);
   dt2 = dt1.add(t1);
   System.out.println("2100, 2, 1!!!, 3, 4, 5 = " + dt2); //2100, 3, 1!!!, 3, 4, 5
 if( dt2.getYear()!=2100 || dt2.getMonth()!=2 || dt2.getDay()!=1 )
     System.out.println("bonus3 WRONG" ); 
 }
}
