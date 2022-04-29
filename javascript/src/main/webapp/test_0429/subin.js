let jsonString = [
    {userId: 'user1', userName: '지수빈', userEmail: 'jee@email.com', userTel: '010-1234-1234',  userBirth: '1995-01-01'},
    {userId: 'user2', userName: '지수빈', userEmail: 'jee@email.com', userTel: '010-1234-1234',  userBirth: '1995-01-01'},
    {userId: 'user3', userName: '지수빈', userEmail: 'jee@email.com', userTel: '010-1234-1234',  userBirth: '1995-01-01'},
    {userId: 'user4', userName: '지수빈', userEmail: 'jee@email.com', userTel: '010-1234-1234',  userBirth: '1995-01-01'},
    {userId: 'user5', userName: '지수빈', userEmail: 'jee@email.com', userTel: '010-1234-1234',  userBirth: '1995-01-01'}
];
let theadAry = ['순번', '선택', '아이디', '이름', '이메일', '전화번호', '생년월일'];

// init
document.addEventListener('DOMContentLoaded', init);
function init() {
    makeThead();
    makeTbody(jsonString);

    // 등록 버튼
    let insertBtn = document.getElementById('insertBtn');
    insertBtn.addEventListener('click', insertBtnCallBack);

    // 전체 선택 버튼
    let chkAllBtn = document.getElementById('chkAll');
    chkAllBtn.addEventListener('click', chkAllCallBack);

    // 선택 삭제 버튼
    let chkDelBtn = document.getElementById('chkDel');
    chkDelBtn.addEventListener('click', chkDelCallBack);
}




// thead 추가
function makeThead() {

    let thead = document.getElementById('thead');
    let tr = document.createElement('tr');
    theadAry.forEach(function(elem) {
        let td = document.createElement('td');
        td.innerHTML = elem;
        tr.appendChild(td);
    });
    thead.appendChild(tr);

}

// tbody 추가
function makeTbody(userData) {

    let tbody = document.getElementById('tbody');
    
    userData.forEach(function(user, idx){
        
        tr = document.createElement('tr');
        tbody.appendChild(tr);
        let td = document.createElement('td');
        td.innerHTML = idx+1;
        tr.appendChild(td);

        td = document.createElement('td');
        let checkbox = document.createElement('input');
        checkbox.setAttribute('type', 'checkbox');
        td.appendChild(checkbox);
        tr.appendChild(td);

        for (field in user) {
            let td = document.createElement('td');
            td.innerHTML = user[field];
            tr.appendChild(td);
            if (field == 'userId') {
                tr.setAttribute('id', user[field]);
            } 
        }
    });
    tbody.appendChild(tr);
}

// 등록 버튼
function insertBtnCallBack() {

    let uId = document.querySelector('input[name=uId]').value;
    let uName = document.querySelector('input[name=uName]').value;
    let uEmail = document.querySelector('input[name=uEmail]').value;
    let uTel = document.querySelector('input[name=uTel]').value;
    let uBirth = document.querySelector('input[name=uBirth]').value;

    if (!(uId || uName || uEmail || uTel || uBirth)) {
        alert('필수 값을 입력하세요.')
        return;
    }

    jsonString.push({userId: uId, userName: uName, userEmail: uEmail, userTel: uTel, userBirth: uBirth});

    let body = document.getElementById('tbody');
    let childTr = document.querySelectorAll('#tbody>tr');
    childTr.forEach(function(elem) {						   
        body.removeChild(elem);
    });

    makeTbody(jsonString);
    let inputs = document.querySelectorAll('#first_left input');
    inputs.forEach(function(elem) {
        elem.value = '';
    });
}


// 전체 선택
function chkAllCallBack() {
    let allTr = document.querySelectorAll('#tbody > tr');
    let chkTrs = [];
    
    allTr.forEach(function(tr) {
        let chkTr = tr.childNodes[1].childNodes[0];
        chkTrs.push(chkTr.checked);
    });

    try {

        chkTrs.forEach(function(bool) {
            if(bool == false) {  
                allTr.forEach(function(tr) {
                    let chkTr = tr.childNodes[1].childNodes[0];
                    chkTr.checked = true;
                })
                throw new Error("stop loop");
            } else {
                allTr.forEach(function(tr) {
                    let chkTr = tr.childNodes[1].childNodes[0];
                    chkTr.checked = false;
            })
            }
        })

    } catch(e) {

    }
    

}

// 선택 삭제
function chkDelCallBack() {
    let allTr = document.querySelectorAll('#tbody > tr');
    allTr.forEach(function(tr) {
        let chkTr = tr.childNodes[1].childNodes[0];
        if (chkTr.checked == true) {
            let trId = tr.getAttribute('id');
            tr.remove();
       
                jsonString.forEach(function(user, idx){
                    if (user['userId'] == trId) {
                        jsonString.splice(idx, 1);
                    }
                });
            
        }
    });
    
}



