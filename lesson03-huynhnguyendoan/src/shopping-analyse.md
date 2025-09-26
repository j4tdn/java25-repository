+Class 
Customer: name, phone, id, address
Item    : id, os, color, cost
=>Oder: customer, item-details[], quantity, date-time
=>ItemDetail:item, quantity

b1: create list of customers
b2: create array of items in store
b3: shopping function
+who is buying
+List of items
+amount of each item
+DateTime

=========================
b.Object
c1: KH1,Adam, 123, NewYork
c2: KH2,Kate,243,California

i1: SS10+,android,black,620
i2: SS20U,Andoid,Green, 840
i3: IP4,IOS,White,280,30
i4:IP12,IOS,Black,880
i5:WP8,WindowPhone,Blue,560

o1: c1, {id1(i1,3),id2(i4,1),id3(i2,1)} 10:10:10 08.5.2021
o2:c2,{id1(i3,2),id2(i5,1)} 20:10:12 07.5.2021
o3: c2,{id1(i4,1)} 09:28:32 08.05.2021

C.Function
+export(order) => TotalOfAmount:void

