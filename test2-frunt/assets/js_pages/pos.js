

let home = document.querySelector('#home');
let cusbtn = document.querySelector('#cusbtn');
let invoibtn = document.querySelector('#invoibtn');
let salesbtn = document.querySelector('#salesbtn');
let suppbtn = document.querySelector('#suppbtn');
let impbtn = document.querySelector('#impbtn');
let usebtn = document.querySelector('#usebtn');

let log = document.querySelector('#log');
let cussec = document.querySelector('#cussec');
let invsec = document.querySelector('#invsec');
let odsec = document.querySelector('#odsec');
let supsec = document.querySelector('#supsec');
let dessec = document.querySelector('#dessec');
let empsec = document.querySelector('#empsec');
let usersec = document.querySelector('#usersec');

cusbtn.addEventListener("click",function(){
  cussec.style.display = 'flex';
  dessec.style.display = 'none';
  invsec.style.display = 'none';
  odsec.style.display = 'none';
  supsec.style.display = 'none';
  empsec.style.display = 'none';
  usersec.style.display = 'none';

});

invoibtn.addEventListener("click",function(){
  cussec.style.display = 'none';
  dessec.style.display = 'none';
  invsec.style.display = 'flex';
  odsec.style.display = 'none';
  supsec.style.display = 'none';
  empsec.style.display = 'none';
  usersec.style.display = 'none';

});

salesbtn.addEventListener("click",function(){
  cussec.style.display = 'none';
  dessec.style.display = 'none';
  invsec.style.display = 'none';
  odsec.style.display = 'flex';
  supsec.style.display = 'none';
  empsec.style.display = 'none';
  usersec.style.display = 'none';
});

suppbtn.addEventListener("click",function(){
  cussec.style.display = 'none';
  dessec.style.display = 'none';
  invsec.style.display = 'none';
  odsec.style.display = 'none';
  supsec.style.display = 'flex';
  empsec.style.display = 'none';
  usersec.style.display = 'none';
});

impbtn.addEventListener("click",function(){
  cussec.style.display = 'none';
  dessec.style.display = 'none';
  invsec.style.display = 'none';
  odsec.style.display = 'none';
  supsec.style.display = 'none';
  empsec.style.display = 'flex';
  usersec.style.display = 'none';
});

usebtn.addEventListener("click",function(){
  cussec.style.display = 'none';
  dessec.style.display = 'none';
  invsec.style.display = 'none';
  odsec.style.display = 'none';
  supsec.style.display = 'none';
  empsec.style.display = 'none';
  usersec.style.display = 'flex';
});

home.addEventListener("click",function(){
  cussec.style.display = 'none';
  dessec.style.display = 'flex';
  invsec.style.display = 'none';
  odsec.style.display = 'none';
  supsec.style.display = 'none';
  empsec.style.display = 'none';
  usersec.style.display = 'none';
});

