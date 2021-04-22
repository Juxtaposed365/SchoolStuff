x = 1
y = 3
z = 5

function sub1(){
    a = 7
    y = 9
    z = 11
    console.log("a: "+a+" y: "+y+" z: "+ z)
    
    function sub2(){
        a = 13
        x = 15
        w = 17
        console.log("a: "+a+" x: "+x+" w: "+w)
        function sub3(){
            a = 19
            b = 21
            w = 23
            console.log("a: "+a+" b: "+b+" w: "+w)
        }
        sub3()
    }
    sub2()
}
sub1()