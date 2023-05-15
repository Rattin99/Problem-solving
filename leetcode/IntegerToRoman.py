

def intToRoman(num):

    numerals = {
        1:'I',
        2:'II',
        3: 'III',
        4:'IV',
        5:'V',
        6:'VI',
        7:'VII',
        8:'VIII',
        9:'IX',
        10:'X',
        20:'XX',
        30:'XXX',
        40: 'XL',
        50:'L',
        60:'LX',
        70:'LXX',
        80:'LXXX',
        90: 'XC',
        100:'C',
        200:'CC',
        300:'CCC',
        400: 'CD',
        500: 'D',
        600:'DC',
        700:'DCC',
        800:'DCCC',
        900: 'CM',
        1000: 'M'
    }

    remainder = num
    Roman = ""
    
    while(remainder > 0):
        
        while(remainder >= 1000):
            n = remainder / 1000
            remainder = remainder - 1000
            Roman += 'M'
       
        while(remainder < 1000 and remainder > 99):
            n = remainder // 100
            n = n*100
            Roman += numerals[n]
            remainder = remainder - n

        while(remainder < 100 and remainder > 9):
            n = remainder // 10
            n = n*10
            Roman += numerals[n]
            remainder = remainder - n
            print(remainder)
        
        if(remainder < 10 and remainder > 0):
            Roman += numerals[remainder]
        
        remainder = 0
    
    return Roman
      
            
print(intToRoman(10))