# Write a Perl program that uses a hash and a large number of operations on the hash. For example, the hash could store 
# people’s names and their ages. A random-number generator could be used to create three-character names and ages, which 
# could be added to the hash. When a duplicate name was generated, it would cause an access to the hash but not add a new 
# element. Rewrite the same program without using hashes. Compare the execution efficiency of the two. Compare the ease of 
# programming and readability of the two.

# The array seems to be more efficient, it takes 1 less second to execute. The array is also more readable because the commas that separate the elements aren't
# related like in the hash. The has also uses commas but has key value pairs. Arrays have a specific size where hashed
# may not reach the size given to them. 


print "Question 3:\n";
# Hash
$hashTimeStart = time();
%values;
$count = 100000000;
while($count > 0){
    #code block
    $some_num = int(rand(10000));
    
    $values{''.($some_num % 100)} = $some_num;
    #print "key:\t".($some_num % 100)."  -->\t". $values{''.($some_num % 100)}."\n";
    
    $count = $count - 1;
}

$hashTimeEnd = time();
print "Hash Time: ".($hashTimeEnd - $hashTimeStart)."\n";
print "------------------------------------------\n";
# Array
$arrayTimeStart = time();
$size = 1000;
@values1[size];
$count1 = 100000000;
while($count1 > 0){
    #code block
    $some_num1 = int(rand(10000));
    
    $values1{''.($some_num1 % 100)} = $some_num1;
    #print "key:\t".($some_num1 % 100)."  -->\t". $values1{''.($some_num1 % 100)}."\n";
    
    $count1 = $count1 - 1;
}

$arrayTimeEnd = time();
print "Array Time: ".($arrayTimeEnd - $arrayTimeStart)."\n";