package osgla1;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
public class cpuscheduling implements ActionListener {
JFrame f1=new JFrame(); // input screen
JFrame f2=new JFrame(); // output screen
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p3=new JPanel();
JPanel p4=new JPanel();
JPanel p5=new JPanel();
JPanel p6=new JPanel();
JLabel l1=new JLabel("Number Of Processors (<=6)");
JLabel l2=new JLabel("Burst Time");
JLabel l3=new JLabel("Arrival Time");
JLabel l4=new JLabel("Priority");
JLabel l5=new JLabel("Time Quantum");
JLabel note=new JLabel("(Lower numbers indicate higher priority)");
String pro []={"P1","P2","P3","P4","P5","P6"};
Map<String,String> tree=new LinkedHashMap(); // original tree of bt as key and at as value
Map<String,String> tree2=new LinkedHashMap();// original tree of at as key and bt as value
Map<String,String> tree3=new LinkedHashMap(); // tree for the preemptive sjf ans
Map<String,String> tree4=new LinkedHashMap(); // tree for preemptive priority ans
Map<String,String> tree5; // duplicate of tree
Map<String,String> tree6; // duplicate of tree
Map<String,String> tree7=new LinkedHashMap(); // tree for the round robin ans
Map<String,String> tree8=new LinkedHashMap(); // tree for priority in which it is in ascending order of priorities
Map<String,String> tree9=new LinkedHashMap(); // tree in increasing order of the arrival time and priority is set as key value
JTextField t1=new JTextField(""); // textfield for burst time
JTextField t2=new JTextField(""); // textfield for arrival time
JTextField t3=new JTextField(""); // textfield for priority
JTextField t4=new JTextField(""); // textfield for time quantum
JComboBox box=new JComboBox(pro); // combo box for selecting the number of processors
JCheckBox bt1=new JCheckBox("First Come First Serve");
JCheckBox bt2=new JCheckBox("Non-Preemptive Shortest Job First");
JCheckBox bt3=new JCheckBox("Preemptive Shortest Job First");
JCheckBox bt4=new JCheckBox("Preemptive Priority ");
JCheckBox bt5=new JCheckBox("Non-Preemptive Priority ");
JCheckBox bt6=new JCheckBox("Round Robin");
JButton comp=new JButton("COMPUTE");
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
cpuscheduling(){
f1.setLayout(null);
f1.setSize(600,600);
f1.setResizable(false);
f1.setLocationRelativeTo(null);
Font f=new Font("Arial",Font.BOLD,15);
l1.setFont(f);
l2.setFont(f);
l3.setFont(f);
l4.setFont(f);
l5.setFont(f);
l1.setBounds(60,15,250,60);
box.setBounds(280, 30,100,30);
l2.setBounds(20,70,250,50);
l3.setBounds(20,120,250,50);
l4.setBounds(20,170,250,50);
f=new Font("Arial",Font.ITALIC,12);
note.setFont(f);
note.setBounds(5,215,250,20);
l5.setBounds(10,240,250,50);
t1.setBounds(120,80,350,30);
t2.setBounds(120,130,350,30);
t3.setBounds(120,180,350,30);
t4.setBounds(120,250,30,30);
f=new Font("Arial",Font.BOLD,15);
bt1.setFont(f);
bt2.setFont(f);
bt3.setFont(f);
bt4.setFont(f);
bt5.setFont(f);
bt6.setFont(f);
bt1.setBounds(10,290,200,50);
bt2.setBounds(270,290 ,300,50);
bt3.setBounds(10,340,250,50);
bt4.setBounds(270,340,220,50);
bt5.setBounds(10,390,200,50);
bt6.setBounds(270,390,220,50);
comp.setBounds(230,470,100,50);
f1.add(l1);
f1.add(l2);
f1.add(l3);
f1.add(l4);
f1.add(l5);
f1.add(t1);
f1.add(t2);
f1.add(t3);
f1.add(note);
f1.add(t4);
f1.add(box);
f1.add(bt1);
f1.add(bt2);
f1.add(bt3);
f1.add(bt4);
f1.add(bt5);
f1.add(bt6);
f1.add(comp);
comp.addActionListener(this);
f2.setLayout(new GridLayout(6,1));
f2.setSize(d.width,d.height);
f2.setResizable(false);
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f1.setVisible(true);
}
public static void main(String args[]){
new cpuscheduling();
}
@Override
public void actionPerformed(ActionEvent e) {
try{
if(e.getSource()==comp&&(bt1.isSelected()||bt2.isSelected()||bt3.isSelected()||bt4.isSelected()||bt5.isSelected()||bt6.isSelected())){
tree.clear();
tree2.clear();
tree3.clear();
tree4.clear();
tree7.clear();
tree8.clear();
tree9.clear();
p1.removeAll();
p2.removeAll();
p3.removeAll();
p4.removeAll();
p5.removeAll();
p6.removeAll();
f2.remove(p1);
f2.remove(p2);
f2.remove(p3);
f2.remove(p4);
f2.remove(p5);
f2.remove(p6);
String no=box.getSelectedItem()+"";
int length=1;
if(no.equals("P1"))
length=1;
else if(no.equals("P2"))
length=2;
else if(no.equals("P3"))
length=3;
else if(no.equals("P4"))
length=4;
else if(no.equals("P5"))
length=5;
else if(no.equals("P6"))
length=6;
String text1=t1.getText();
String text2=t2.getText();
if(text1.length()==0||text2.length()==0)
JOptionPane.showMessageDialog(null,"You have entered less number of inputs");
String [] af=text1.split("[, ]"); // burst time
String [] a=text2.split("[, ]"); // arrival
String [] attt=text2.split("[, ]"); // arrival
if(af.length<length||a.length<length)
JOptionPane.showMessageDialog(null,"You have entered less number of inputs");
int mm[]=new int[length];
int mt[]=new int[length];
String ak[]=new String[length];
String acal[]=new String[length]; // duplicate of original burst time array
double t_bt=0; // for calculating total burst time
JLabel g1=new JLabel("");
JLabel g2=new JLabel("");
JLabel g3=new JLabel("");
JLabel g4=new JLabel("");
JLabel g5=new JLabel("");
JLabel g6=new JLabel("");
int array2[]=new int[length]; // arrival time
int aa1[]=new int[length];
int aa2[]=new int[length];
int arr_for_prio[]=new int[length];
int acal1[]=new int[length];
for(int i=0;i<length;i++){ // for loop for copying the contents of the arrival and busrt time array
array2[i]=Integer.parseInt(a[i]);
mm[i]=Integer.parseInt(af[i]);
aa1[i]=Integer.parseInt(af[i]);
aa2[i]=Integer.parseInt(a[i]);
acal[i]=af[i];
acal1[i]=Integer.parseInt(af[i]);
arr_for_prio[i]=Integer.parseInt(a[i]);
t_bt+=(Integer.parseInt(af[i]));
}
Arrays.sort(array2);
if(bt5.isSelected()||bt4.isSelected()){ // if any of the priority option is selected
String text3=t3.getText();
if(text3.length()==0)
JOptionPane.showMessageDialog(null,"You have not entered priorities");
String [] prio=text3.split("[, ]"); // abstracting the priority array
if(prio.length<length)
JOptionPane.showMessageDialog(null,"You have not entered priorities"); // displaying the error
int prio2[]=new int[length];
for(int i=0;i<length;i++){
prio2[i]=Integer.parseInt(prio[i]);
ak[i]=prio[i];
}
Arrays.sort(prio2);
for(int i=0;i<length;i++){
for(int j=0;j<length;j++){
if(prio2[i]==(Integer.parseInt(ak[j])))
{
tree8.put(prio2[i]+" "+(j+1),attt[j]+" "+(j+1));// making a tree in which riority is the key
ak[j]="-1";
break;
}
}
}
for(int i=0;i<length;i++){
for(int j=0;j<length;j++){
if(array2[i]==arr_for_prio[j])
{
tree9.put(array2[i]+" "+(j+1),prio[j]+" "+(j+1));
arr_for_prio[j]=-1;
break;
}
}
}
}
int array1[]=new int[length];
for(int i=0;i<length;i++){
for(int j=0;j<length;j++){
if(array2[i]==Integer.parseInt(a[j]))
{
array1[i]=Integer.parseInt(af[j]);
tree.put(array2[i]+" "+(j+1),array1[i]+" "+(j+1));
a[j]="-1";
break;
}
}
}
Arrays.sort(mm);
for(int i=0;i<length;i++){
for(int j=0;j<length;j++){
if(mm[i]==(Integer.parseInt(af[j])))
{
mt[i]=array2[j];
tree2.put(mm[i]+" "+(j+1),attt[j]+" "+(j+1));
af[j]="-1";
break;
}
}
}
for(int i=0;i<length;i++){
if(i==0){
g1=new JLabel(array2[i]+"");
g2=new JLabel(array2[i]+"");
g3=new JLabel(array2[i]+"");
g4=new JLabel(array2[i]+"");
g5=new JLabel(array2[i]+"");
g6=new JLabel(array2[i]+"");
}
}
tree5=new LinkedHashMap(tree);
tree6=new LinkedHashMap(tree);
if(bt1.isSelected()){ // first checkkbox
JLabel label=new JLabel("FIRST COME FIRST SERVE:");
Font f=new Font("Arial",Font.BOLD,15); // setting the font
label.setFont(f);
label.setForeground(Color.BLUE); // setting the colour
p1.setLayout(null); // panel of the fcfs
label.setBounds(50,0,200,50);
p1.add(label);
int sum=0,c=0,ii=0;
for(Map.Entry<String,String>entry : tree.entrySet())
{
String ans[]=entry.getKey().split(" "); // spliting the value
sum=Integer.parseInt(ans[0]);
break;
}
int []array3=new int[length];
int sum1=aa2[0];
for (Map.Entry<String,String>entry : tree.entrySet()){
String ans[]=entry.getValue().split(" ");
l1=new JLabel(" P"+ans[1]);
l1.setHorizontalAlignment(SwingConstants.CENTER); // aligning it in center
int m=Integer.parseInt(ans[0]);
ii=Integer.parseInt(ans[1])-1;
sum+=m;
array3[ii]=sum;
l2=new JLabel(sum+"");
Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // applying border
int sl=(int)((((sum-sum1))/t_bt)*(1352)); // mainting the ratio to display it
sum1=sum;
l1.setBounds(c,40,sl,30);
l2.setBounds(c+sl-9,55,sl,50);
l1.setOpaque(true);
l1.setBackground(Color.WHITE);
l1.setBorder(border);
p1.add(l1);
p1.add(l2);
c+=sl;
}
g1.setBounds(0,55,50,50);
p1.add(g1);
int [] array4=new int[length]; // turn around time
int [] array5=new int[length]; // wait time
double avgwaiting=0;
double avgturn=0;
for(int j=0;j<length;j++){
array4[j]=array3[j]-(aa2[j]);
array5[j]=array4[j]-(aa1[j]);
avgwaiting+=array4[j];
avgturn+=array5[j];
}
JLabel print; // printing the values on 2nd screen
print=new JLabel("Waiting Time: ");
print.setBounds(50,80,100,35);
p1.add(print);
f2.add(p1);
print=new JLabel("Turn Around Time:");
print.setBounds(50,100,120,35);
p1.add(print);
int cc=170;
for(int j=0;j<length;j++){
print=new JLabel("P"+(j+1)+"= "+array5[j]+", ");
print.setBounds(cc,80,100,35);
p1.add(print);
print=new JLabel("P"+(j+1)+"= "+array4[j]+", ");
print.setBounds(cc,100,100,35);
p1.add(print);
cc+=70;
}
double avg1=avgwaiting/length; // calculating average waiting time
double avg2=avgturn/length;
print=new JLabel("Average= "+avg2+"");
print.setBounds(cc,80,200,35);
p1.add(print);
print=new JLabel("Average= "+avg1+""); // displaying average turn around time
print.setBounds(cc,100,200,35);
p1.add(print);
f2.add(p1);
}
if(bt2.isSelected()){ // 2nd checkbox
int sum=0,ii=0,c=0;
JLabel label=new JLabel("NON PREEMPTIVE SJF:");
Font f=new Font("Arial",Font.BOLD,15);
label.setFont(f);
label.setForeground(Color.BLUE);
p2.setLayout(null);
label.setBounds(50,0,200,50);
p2.add(label);
int []array3=new int[length]; // array for maintaining the final completion times
for(Map.Entry<String,String>entry : tree.entrySet())
{
String ans[]=entry.getKey().split(" ");
sum=Integer.parseInt(ans[0]); // intialzing sum with the first arrival time
break;
}
int sum1=aa2[0];
while(tree2.size()!=0){ // traversing the tree with key as increasing time of bt
for(Map.Entry<String, String>entry2:tree2.entrySet()){
String ans2[]=entry2.getValue().split(" ");
String cal[]=entry2.getKey().split(" ");
if((Integer.parseInt(ans2[0]))<=sum)
{
String ans3[]=entry2.getValue().split(" ");
l1=new JLabel(" P"+ans3[1]); // displaying processor id
l1.setHorizontalAlignment(SwingConstants.CENTER);
int m3=Integer.parseInt(cal[0]);
sum+=m3;
ii=Integer.parseInt(ans3[1])-1;
array3[ii]=sum;
l2=new JLabel(sum+""); // sum for completion time display
Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
int sl=(int)((((sum-sum1)/t_bt))*(1352)); // maintaining the ratio
sum1=sum;
l1.setBounds(c,40,sl,30);
l2.setBounds(c+sl-9,55,sl,50);
l1.setOpaque(true);
l1.setBackground(Color.WHITE);
l1.setBorder(border); // setting the border
p2.add(l1);
p2.add(l2);
c+=sl;
tree2.remove(entry2.getKey()); // when that key is used we delete it
break;
}
}
}
g2.setBounds(0,55,50,50); // g2 is first arrival time
p2.add(g2);
int [] array4=new int[length]; // turn around time
int [] array5=new int[length]; // wait time
double avgwaiting=0;
double avgturn=0;
for(int j=0;j<length;j++){
array4[j]=array3[j]-(aa2[j]); // calculating the waiting time
array5[j]=array4[j]-(aa1[j]); // calculating the turn around time
avgwaiting+=array4[j];
avgturn+=array5[j];
}
JLabel print; // printing the values on 2nd screen
print=new JLabel("Waiting Time: ");
print.setBounds(50,80,100,35);
p2.add(print);
f2.add(p2);
print=new JLabel("Turn Around Time:");
print.setBounds(50,100,120,35);
p2.add(print);
int cc=170;
for(int j=0;j<length;j++){
print=new JLabel("P"+(j+1)+"= "+array5[j]+", "); //Displaying WT for all processes
print.setBounds(cc,80,100,35);
p2.add(print);
print=new JLabel("P"+(j+1)+"= "+array4[j]+", "); // Displaying TAT for all processes
print.setBounds(cc,100,100,35);
p2.add(print);
cc+=70;
}
double avg1=avgwaiting/length;
double avg2=avgturn/length;
print=new JLabel("Average= "+avg2+"");
print.setBounds(cc,80,200,35);
p2.add(print);
print=new JLabel("Average= "+avg1+"");
print.setBounds(cc,100,200,35);
p2.add(print);
f2.add(p2);
}
if(bt3.isSelected()){ // checkbox 3 selected
int n=tree5.size(),complete=0,time=0,min=Integer.MAX_VALUE,i=-1,count=0;
int shortest=0; // calculating currently visited shorted burst time
int key=0;
boolean flag=false;
while(complete!=n){ // when all processes are not visited, till then the loop will work
for(Map.Entry<String,String>entry : tree5.entrySet()){
String att[]=entry.getKey().split(" ");
; int m=Integer.parseInt(att[0]);
String ans2[]=entry.getValue().split(" ");
int m2=Integer.parseInt(ans2[0]);
if(m<=time && m2<=min&& m2>0){ // comparing with minimum burst time and the arrival time should be less than the current time going on
int k=Integer.parseInt(ans2[1]);
if(min==m2 && k<shortest){
shortest=Integer.parseInt(ans2[1]); // setting the current shortest burst time
key=Integer.parseInt(att[0]);
}
else if(min!=m2) // if the must time of processes are same then compare according to processor id
{
shortest=Integer.parseInt(ans2[1]);
key=Integer.parseInt(att[0]);
}
min=m2;
flag=true;
}
}
if(flag==false){ // if it is no burst time is found then increase the time without doing any further incrementation
time+=1;
continue;
}
time+=1;
if(i==-1||i==shortest){
tree3.remove((time-1)+"");
tree3.put(time+"",shortest+" "+count); // tree3 is the tree for maintaining the completion time
}
else if(i!=shortest){
count+=1;
tree3.put(time+"",shortest+" "+count);
}
min-=1;
tree5.put(key+" "+shortest,min+" "+shortest);// replace the current tree with updated value
if(min==0){
min=Integer.MAX_VALUE;
complete+=1; // increasing if the burst time for a process becomes 0
flag=false;
}
i=shortest;
}
int sum=aa2[0],ii=0,c=0;
JLabel label=new JLabel("PREEMPTIVE SJF:");
Font f=new Font("Arial",Font.BOLD,15);
label.setFont(f); // setting the font
label.setForeground(Color.BLUE);
p3.setLayout(null);
label.setBounds(50,0,200,50);
p3.add(label);
int []array3=new int[length];
for(Map.Entry<String,String>entry:tree3.entrySet()){ // displaying the chart using labels
int m=Integer.parseInt(entry.getKey());
String ans2[]=entry.getValue().split(" ");
int m2=Integer.parseInt(ans2[0]);
array3[m2-1]=m;
l1=new JLabel(" P"+m2);
l1.setHorizontalAlignment(SwingConstants.CENTER);
l2=new JLabel(m+"");
Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // setting the border
int sl=(int)(((m-sum)/t_bt)*(1352));
sum=m;
l1.setBounds(c,40,sl,30);
l2.setBounds(c+sl-9,55,sl,50); // setting the bounds for the completion time
l1.setOpaque(true);
l1.setBackground(Color.WHITE);
l1.setBorder(border);
p3.add(l1); // adding the panel of preemptive sjf to the output frame
p3.add(l2);
c+=sl;
}
f2.add(p3);
g3.setBounds(0,55,50,50);
p3.add(g3);
int [] array4=new int[length]; // turn around time
int [] array5=new int[length]; // wait time
double avgwaiting=0;
double avgturn=0;
for(int j=0;j<length;j++){
array4[j]=array3[j]-(aa2[j]); // calculation for wait and turn around time
array5[j]=array4[j]-(aa1[j]);
avgwaiting+=array4[j];
avgturn+=array5[j];
}
JLabel print; // printing the values on 2nd screen
print=new JLabel("Waiting Time: ");
print.setBounds(50,80,100,35);
p3.add(print);
f2.add(p3);
print=new JLabel("Turn Around Time:");
print.setBounds(50,100,120,35);
p3.add(print);
int cc=170;
for(int j=0;j<length;j++){
print=new JLabel("P"+(j+1)+"= "+array5[j]+", ");
print.setBounds(cc,80,200,35); // after calculating displaying to output screen
p3.add(print);
print=new JLabel("P"+(j+1)+"= "+array4[j]+", ");
print.setBounds(cc,100,200,35);
p3.add(print);
cc+=70;
}
double avg1=avgwaiting/length;
double avg2=avgturn/length;
print=new JLabel("Average= "+avg2+"");
print.setBounds(cc,80,200,35);
p3.add(print);
print=new JLabel("Average= "+avg1+"");
print.setBounds(cc,100,200,35);
p3.add(print);
f2.add(p3);
}
if(bt4.isSelected()){ // checkbox 4
int n=tree9.size(),complete=0,time=0,min=Integer.MAX_VALUE,min1=Integer.MAX_VALUE,i=-1,count=0;
int shortest=0,st=0;
int key=0;
boolean flag=false;
while(tree9.size()!=0){ // till when the tree is not empty
for(Map.Entry<String,String>entry : tree9.entrySet()){
String att[]=entry.getKey().split(" ");
int m=Integer.parseInt(att[0]);
String ans2[]=entry.getValue().split(" ");
int m2=Integer.parseInt(ans2[0]);
if(m<=time && m2<=min){ // if the priority is highest i.e. lower number
int k=Integer.parseInt(ans2[1]);
if(min==m2 && k<st){
st=Integer.parseInt(ans2[1]); // extracting the process id
key=m;
}
else if(min!=m2){
st=Integer.parseInt(ans2[1]);
key=m;
}
min=m2; // updating the min value
flag=true; // updating the flag
}
}
if(flag==false)
{
time+=1; // continue if no min priority found
continue;
}
time+=1;
if(i==st)
{
tree4.remove((time-1)+"");
tree4.put(time+"",st+" "+count); // tree for the completion times of preemptive priority
}
else
tree4.put(time+"",st+" "+count);
count+=1;
acal1[st-1]-=1;
if(acal1[st-1]==0){
min=Integer.MAX_VALUE; // updating the min if the busrt time is 0 for a particular process
flag=false;
tree9.remove(key+" "+st);
}
i=st;
}
int sum=aa2[0],ii=0,c=0;
JLabel label=new JLabel("PREEMPTIVE PRIORITY:");
Font f=new Font("Arial",Font.BOLD,15);
label.setFont(f); // setting the fonts of the labels
label.setForeground(Color.BLUE);
p4.setLayout(null);
label.setBounds(50,0,200,50);
p4.add(label);
int []array3=new int[length]; // array for maintaining the completion times of the processes
for(Map.Entry<String,String>entry:tree4.entrySet()){
int m=Integer.parseInt(entry.getKey());
String ans2[]=entry.getValue().split(" ");
int m2=Integer.parseInt(ans2[0]);
array3[m2-1]=m;
l1=new JLabel("P"+m2);
l1.setHorizontalAlignment(SwingConstants.CENTER); // center the process id
l2=new JLabel(m+"");
Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
int sl=(int)(((m-sum)/t_bt)*(1352)); // maintaining the ratio
sum=m;
l1.setBounds(c,40,sl,30);
l2.setBounds(c+sl-9,55,sl,50);
l1.setOpaque(true);
l1.setBackground(Color.WHITE); // setting the background color of the label
l1.setBorder(border);
p4.add(l1);
p4.add(l2);
c+=sl;
}
f2.add(p4);
g4.setBounds(0,55,50,50); // set bounds to the initial value of the arrival time
p4.add(g4);
int [] array4=new int[length]; // turn around time
int [] array5=new int[length]; // wait time
double avgwaiting=0;
double avgturn=0;
for(int j=0;j<length;j++){
array4[j]=array3[j]-(aa2[j]);
array5[j]=array4[j]-(aa1[j]);
avgwaiting+=array4[j];
avgturn+=array5[j];
}
JLabel print; // printing the values on 2nd screen
print=new JLabel("Waiting Time: ");
print.setBounds(50,80,100,35);
p4.add(print);
f2.add(p4);
print=new JLabel("Turn Around Time:");
print.setBounds(50,100,120,35);
p4.add(print);
int cc=170;
for(int j=0;j<length;j++){
print=new JLabel("P"+(j+1)+"= "+array5[j]+", "); // adding WT to the ouput screen
print.setBounds(cc,80,100,35);
p4.add(print);
print=new JLabel("P"+(j+1)+"= "+array4[j]+", ");
print.setBounds(cc,100,100,35); // adding TAT to the output screen
p4.add(print);
cc+=70;
}
double avg1=avgwaiting/length;
double avg2=avgturn/length;
print=new JLabel("Average= "+avg2+"");
print.setBounds(cc,80,200,35);
p4.add(print); // adding the panel of the preemptive priority to the frame
print=new JLabel("Average= "+avg1+"");
print.setBounds(cc,100,200,35);
p4.add(print);
f2.add(p4);
}
if(bt5.isSelected()){ // checkbox 5th selected
int sum=0,ii=0,c=0;
JLabel label=new JLabel("NON PREEMPTIVE PRIORITY:");
Font f=new Font("Arial",Font.BOLD,15);
label.setFont(f);
label.setForeground(Color.BLUE);
p5.setLayout(null); // p5 is the panel for the non preemptive priority
label.setBounds(50,0,300,50);
p5.add(label);
int []array3=new int[length]; // array for the completion time
for(Map.Entry<String,String>entry : tree.entrySet()) // traversing the array
{
String ans[]=entry.getKey().split(" ");
sum=Integer.parseInt(ans[0]); // extracting the first arrival time
break;
}
int sum1=aa2[0];
while(tree8.size()!=0){
for(Map.Entry<String, String>entry2:tree8.entrySet()){
String ans2[]=entry2.getValue().split(" ");
String cal[]=entry2.getKey().split(" "); // traversing in order of maximum priority first
if((Integer.parseInt(ans2[0]))<=sum)
{
String ans3[]=entry2.getValue().split(" ");
l1=new JLabel("P"+ans3[1]);
l1.setHorizontalAlignment(SwingConstants.CENTER);
int ss=Integer.parseInt(ans3[1]);
int m3=Integer.parseInt(acal[ss-1]); // getting burst time corresponding to that priority
sum+=m3;
ii=Integer.parseInt(ans3[1])-1;
array3[ii]=sum; // putting the completion time in a array
l2=new JLabel(sum+"");
Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // setting the border of the label
int sl=(int)(((sum-sum1)/t_bt)*(1352));
sum1=sum;
l1.setBounds(c,40,sl,30);
l2.setBounds(c+sl-9,55,sl,50); // setting bounds for the completion time display
l1.setOpaque(true);
l1.setBackground(Color.WHITE);
l1.setBorder(border);
p5.add(l1);
p5.add(l2);
c+=sl;
tree8.remove(entry2.getKey()); // if that priority is completed then delete from the tree
break;
}
}
}
g5.setBounds(0,55,50,50);
p5.add(g5);
int [] array4=new int[length]; // turn around time
int [] array5=new int[length]; // wait time
double avgwaiting=0;
double avgturn=0;
for(int j=0;j<length;j++){
array4[j]=array3[j]-(aa2[j]); // calculation of the WT of the processes
array5[j]=array4[j]-(aa1[j]); // calculation of the TAT of the processes
avgwaiting+=array4[j];
avgturn+=array5[j];
}
JLabel print; // printing the values on 2nd screen
print=new JLabel("Waiting Time: ");
print.setBounds(50,80,100,35);
p5.add(print); //printing the average time on the output screen
f2.add(p5);
print=new JLabel("Turn Around Time:");
print.setBounds(50,100,120,35);
p5.add(print);
int cc=170;
for(int j=0;j<length;j++){
print=new JLabel("P"+(j+1)+"= "+array5[j]+", ");
print.setBounds(cc,80,100,35);
p5.add(print);
print=new JLabel("P"+(j+1)+"= "+array4[j]+", ");
print.setBounds(cc,100,100,35);
p5.add(print);
cc+=70;
}
double avg1=avgwaiting/length; // calculate the average time of TAT and WT
double avg2=avgturn/length;
print=new JLabel("Average= "+avg2+"");
print.setBounds(cc,80,200,35);
p5.add(print);
print=new JLabel("Average= "+avg1+"");
print.setBounds(cc,100,200,35);
p5.add(print);
f2.add(p5);
}
if(bt6.isSelected()){
int sum=0,count=0;
String q=t4.getText();
if(q.length()==0) // showing error if round robin is selected but time quantum is not put
JOptionPane.showMessageDialog(null,"You have not entered time quantum for calculation of round robin.");
tree7.clear();
while(true){ // traversing until tree6 is empty
if(tree6.size()==0)
{
break;
}
else{
for(Map.Entry<String,String>entry:tree6.entrySet()){
String ans[]=entry.getKey().split(" ");
String ans1[]=entry.getValue().split(" ");
if(count==0)
sum=Integer.parseInt(ans[0]);
for(Map.Entry<String,String>entry2:tree6.entrySet()){
String ans3[]=entry2.getKey().split(" ");
String ans4[]=entry2.getValue().split(" ");
if((Integer.parseInt(ans3[0]))<(Integer.parseInt(ans[0])))
{
ans[0]=ans3[0];
ans[1]=ans3[1]; // maintaining the ready queue for which process come first
ans1[1]=ans3[1];
ans1[0]=ans4[0];
}
}
if(Integer.parseInt(ans[0])<=sum){
tree6.remove(ans[0]+" "+ans[1]);
int cal=Integer.parseInt(ans1[0]);
if(cal<(Integer.parseInt(q))){
sum+=cal; // if it is in first position in the ready queue then it is allowed to enter first
cal=0;
}
else{
sum+=Integer.parseInt(q);
cal-=Integer.parseInt(q);
}
if(cal!=0)
tree6.put(sum+" "+ans[1],cal+" "+ans[1]);
tree7.put(ans[1]+" "+count,sum+"");
count+=1;
break;
}
}
}
}
sum=aa2[0];
int ii=0,c=0;
JLabel label=new JLabel("ROUND ROBIN:");
Font f=new Font("Arial",Font.BOLD,15);
label.setFont(f);
label.setForeground(Color.BLUE);
p6.setLayout(null);
label.setBounds(50,0,200,50);
p6.add(label);
int []array3=new int[length];
for(Map.Entry<String,String>entry:tree7.entrySet()){ // displaying on the output screen
String ans2[]=entry.getKey().split(" ");
int m=Integer.parseInt(entry.getValue());
int m2=Integer.parseInt(ans2[0]);
array3[m2-1]=m;
l1=new JLabel("P"+m2);
l1.setHorizontalAlignment(SwingConstants.CENTER);
l2=new JLabel(m+"");
Border border = BorderFactory.createLineBorder(Color.BLACK,2);
int sl=(int)(((m-sum)/t_bt)*(1352));
sum=m;
l1.setBounds(c,40,sl,30);
l2.setBounds(c+sl-9,55,sl,50);
l1.setOpaque(true);
l1.setBackground(Color.WHITE);
l1.setBorder(border);
p6.add(l1);
p6.add(l2);
c+=sl;
}
f2.add(p6);
g6.setBounds(0,55,50,50);
p6.add(g6);
int [] array4=new int[length]; // turn around time
int [] array5=new int[length]; // wait time
double avgwaiting=0;
double avgturn=0;
for(int j=0;j<length;j++){
array4[j]=array3[j]-(aa2[j]);
array5[j]=array4[j]-(aa1[j]);
avgwaiting+=array4[j];
avgturn+=array5[j];
}
JLabel print; // printing the values on 2nd screen
print=new JLabel("Waiting Time: ");
print.setBounds(50,80,100,35);
p6.add(print);
f2.add(p6);
print=new JLabel("Turn Around Time:");
print.setBounds(50,100,120,35);
p6.add(print);
int cc=170;
for(int j=0;j<length;j++){
print=new JLabel("P"+(j+1)+"= "+array5[j]+", ");
print.setBounds(cc,80,100,35);
p6.add(print);
print=new JLabel("P"+(j+1)+"= "+array4[j]+", ");
print.setBounds(cc,100,100,35);
p6.add(print);
cc+=70;
}
double avg1=avgwaiting/length;
double avg2=avgturn/length;
print=new JLabel("Average= "+avg2+"");
print.setBounds(cc,80,200,35);
p6.add(print);
print=new JLabel("Average= "+avg1+"");
print.setBounds(cc,100,200,35);
p6.add(print);
f2.add(p6);
}
f2.setVisible(true);
}
else{
JOptionPane.showMessageDialog(null,"No checkbox selected."); // displaying the error if no chevkbox selected
}
}
catch(Exception e1){
// if exception occured due to some reason
}
}
}// end of the code