let inp = document.getElementsByClassName("inp")[0];
let val = document.querySelectorAll(".val")
let bb = document.getElementsByClassName("bb")[0];

let flag = "n";

function action() {
    
    let clickedValue = this.innerHTML;

    if (clickedValue === ".") {
        
        if (flag === "n") {
            inp.value += clickedValue;
            flag = "y";
        }
    } else {
        inp.value += clickedValue;
    }
}

for (let i = 0; i < val.length; i++) {
    val[i].addEventListener("click", action);
}

bb.addEventListener("click",()=>{
	inp.value = inp.value.slice(0,-1)
})

