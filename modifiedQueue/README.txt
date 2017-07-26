Summary:

This is the modified queue, where people can join from the back of the queue and leave from the front
For every person that joins the queue, the people become more impatient as they expect to be served soon
If they run out of patience, they quit the line(unless if they are first)
There is the ability to add a VIP, who has a certain amount of vip, and if you choose to use the specialized method in the queue, where he (or she) will be put in his VIP slot
You serve from the from of the line. Yeah.

-----------------------------------------------------------------------------
Class Description

To create a person, you make a person object with one of 4 constructors
The first is a blank constructor, which creates a 5 letter name randomly
The second is one that takes in a string as a name
both default impatience to 5 and vip is to put at the end
the next is one that takes in a name and a int for impatience (vip is at end)
the final one has all of those parameters and also needs a int at the end for the vip status
They all have a default ID
There is the ability to increment decrement change getImpatience get the id get name, set name
and also some overriden methods from Object
VIP denotes the place that the person will be put in the queue


Add these peoples to the Queue

Start the queue, it has a blank constructor.
When you leave, you return a Element of type person
you can join and add a person
insert Vip and add a person with a vip status
everytime you add, everyone in the queue's impatience gets incremented
somebody leaving decrements the impatience of the group
You can find a person though just find(Person),you can also find the person though finding through by id or name

Node is a helper class for the code