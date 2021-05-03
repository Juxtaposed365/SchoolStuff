public class NumLit {
    int value;

    // Unary OPs:
    // postinc(), postdec()
    // preinc(), predec()
    Object postinc(){
        value = value++;
        return value;
    }

    Object postdec(){
        value = value--;
        return value;
    }

    Object preinc(){
        value += 1;
        return value;
    }

    Object predec(){
        value -= 1;
        return value;
    }

    // Binary OPs: 
    // multiply(),  greatereq(),  bitand()
    Object multiply(int val){
        value *= val;
        return value;
    }

    Object greatereq(int val){
        if (value >= val){
            value = 1;
            return value;
        }else {
            value = 0; 
            return value;
        }   
    }

    Object bitand(int val){
       value = value & val; 
       return value; 
    }


    // add(),  subtract(),  lesseq()
    Object add(int val){
        value += val;
        return value;
    }

    Object subtract(int val){
        value -= val;
        return value;
    }

    Object lesseq(int val){
        if (value <= val){
            value = 1;
            return value;
        }else {
            value = 0; 
            return value;
        }   
    }

    // tonegative(),  topositive(),  mod()
    Object tonegative(){
        value *= -1;
        return value;
    }

    Object topositive(){
        if(value >= 0){
            value *= 1; 
            return value;
        }else{
            value *= -1;
            return value;
        }
    }

    Object mod(int val){
        value %= val;
        return value;
    }

    // greater(),  less()
    Object greater(int val){
        if (value > val){
            value = 1;
            return value;
        }else {
            value = 0; 
            return value;
        }   
    }

    Object less(int val){
        if (value < val){
            value = 1;
            return value;
        }else {
            value = 0; 
            return value;
        }   
    }


    // and(),  divide(),  not()
    Object and(int val){
        if(value >= 1 && val >= 1){
            value = 1; 
            return value;
        }else{
            value = 0;
            return value;
        }
    }

    Object divide(int val){
        value /= val;
        return value;
    }

    Object not(){
        if (value >= 1){
            value = 0;
            return value;
        }else {
            value = 1; 
            return value;
        }   
    }
    // or(),  xor()
    Object or(int val){
        if(value >= 1 || val >= 1){
            value = 1;
            return value; 
        }else{
            value = 0;
            return value;
        }
    }

    Object xor(int val){
        if((value >= 1 && val < 1) || (value < 1 && val >= 1)){
            value = 1; 
            return value;
        }else{
            value = 0;
            return value;
        }
    }
    // assign(),  divequal()
    Object assign(int val){
        value = val;
        return value;
    }

    Object diveqal(int val){
        value /= val;
        return value;
    }
    

}
