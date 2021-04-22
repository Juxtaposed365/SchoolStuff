# Write a JavaScript and Python script that has subprograms nested three deep and in which each nested subprogram 
# references variables defined in all of its enclosing subprograms and also has variables used to hide at least 1 
# variable from a non-local function.

x = 1
y = 3
z = 5

def sub1():
    a = 7
    y = 9
    z = 11
    print('a:',a,'y:',y,'z:',z)
    
    def sub2():
        global x
        a = 13
        x = 15
        w = 17
        print('a:',a,'x:',x,'w:',w)
        def sub3():
            nonlocal a
            a = 19
            b = 21
            w = 23
            print('a:',a,'b:',b,'w:',w)
        sub3()

    sub2()

sub1()