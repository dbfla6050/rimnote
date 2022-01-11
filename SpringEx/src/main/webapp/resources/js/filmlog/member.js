/**
 * 
 */

let t = document.querySelector("#target")
let id = document.querySelector("#id");
let idMsg = document.querySelector("#idMsg");
let pass = document.querySelector("#pass");
let passMsg = document.querySelector("#passMsg");
let compare = document.querySelector("#compare");
let num_btn = document.querySelector("#num_btn");
let passNum = document.querySelector("#passNum");

id.onchange = checkId;
pass.onchange = checkPw;
compare.onchange = comparePw;


function checkId(){
  if(id.value.length < 8 || id.value.length > 12){
    idMsg.innerHTML = "아이디의 길이를 8자 이상 12자 이하로 만들어 주세요.";
    idMsg.style.color = "red";
    userId.select();
    userId.focus();
  } else {
    idMsg.innerHTML = "입력하였습니다.";
    idMsg.style.color = "blue";
  }
}
function checkPw(){
  if(pass.value.length < 8 || pass.value.length > 12){
    passMsg.innerHTML = "비밀번호 길이를 8자 이상 12자 이하로 만들어 주세요."
    passMsg.style.color = "red";
    pass.value = "";
    pass.focus();
  } else {
    passMsg.innerHTML = "입력하였습니다.";
    passMsg.style.color = "blue";
  }
}
function comparePw(){
  if(pass.value != compare.value){
    compareMsg.innerHTML = "비밀번호가 다릅니다. 다시 확인해주세요."
    compareMsg.style.color = "red";
    compare.value = "";
    compare.focus();
  } else {
    compareMsg.innerHTML = "입력하였습니다.";
    compareMsg.style.color = "blue";
  }
}
num_btn.addEventListener("click",function(e){
  e.preventDefault();
  phoneNum = Math.floor(Math.random()*99999); 
  alert("인증번호가 발송되었습니다.");
  passNum.value = phoneNum;
})
t.addEventListener("click",function(e){
  e.preventDefault();
})
