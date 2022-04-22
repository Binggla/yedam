// object/table.js

const jsonObj = `[{"id":1,"first_name":"Ulrikaumeko","last_name":"Ruffle","email":"uruffle0@360.cn","gender":"Female","ip_address":"106.194.9.144"},
{"id":2,"first_name":"Engracia","last_name":"Pandey","email":"epandey1@webs.com","gender":"Female","ip_address":"90.243.251.113"},
{"id":3,"first_name":"Wolfy","last_name":"Fevier","email":"wfevier2@icio.us","gender":"Male","ip_address":"123.197.37.41"},
{"id":4,"first_name":"Devonna","last_name":"Hoyer","email":"dhoyer3@fc2.com","gender":"Female","ip_address":"25.35.236.14"},
{"id":5,"first_name":"Gram","last_name":"Wagon","email":"gwagon4@scribd.com","gender":"Male","ip_address":"71.100.131.65"},
{"id":6,"first_name":"Der","last_name":"Ancell","email":"dancell5@cmu.edu","gender":"Male","ip_address":"20.45.75.0"},
{"id":7,"first_name":"Cindelyn","last_name":"Klimas","email":"cklimas6@chron.com","gender":"Female","ip_address":"241.231.123.174"},
{"id":8,"first_name":"Gradeigh","last_name":"Gilston","email":"ggilston7@plala.or.jp","gender":"Male","ip_address":"238.227.111.136"},
{"id":9,"first_name":"Raynor","last_name":"Ripsher","email":"rripsher8@wix.com","gender":"Male","ip_address":"108.172.201.241"},
{"id":10,"first_name":"Yulma","last_name":"Lochrie","email":"ylochrie9@home.pl","gender":"Male","ip_address":"185.76.246.22"},
{"id":11,"first_name":"Dehlia","last_name":"Rottery","email":"drotterya@go.com","gender":"Female","ip_address":"3.10.227.172"},
{"id":12,"first_name":"Carling","last_name":"Whicher","email":"cwhicherb@reverbnation.com","gender":"Male","ip_address":"226.111.139.148"},
{"id":13,"first_name":"Alisander","last_name":"Sutherland","email":"asutherlandc@wunderground.com","gender":"Male","ip_address":"8.239.15.56"},
{"id":14,"first_name":"Jammal","last_name":"Flaunders","email":"jflaundersd@feedburner.com","gender":"Male","ip_address":"118.18.96.75"},
{"id":15,"first_name":"Lenci","last_name":"McCerery","email":"lmccererye@blogtalkradio.com","gender":"Agender","ip_address":"45.204.152.171"}]`

// json 문자열을 javascript 오브젝트로 변경
const objAry = JSON.parse(jsonObj);
console.log(objAry);

  // <table>
  // </table>
  let fields = ['id', 'first_name', 'last_name', 'email'];
  function showTable(ary) {
    let tableTag = "";
    tableTag += '<table border=1>';
    tableTag += createHead();
    tableTag += createBody(ary);
    tableTag += '</table>';
    
    document.write(tableTag);
  }

  // <thead><tr><th>항목갯수</th></tr></thead>
  function createHead() {
    let headTag = "";
    headTag += '<thead><tr>'

    fields.forEach(function (val) {
      headTag += `<th>${val}</th>`
    })

    headTag += '</tr></thead>'
    console.log(headTag);

    return headTag;
  }

  // <tbody><tr><td>항목갯수</td>건수</tr></tbody>
  function createBody(ary) {
    let bodyTag = "";
    bodyTag += '<tbody>';

    ary.forEach(function(val, idx) {
      bodyTag += `<tr style="background:${idx%2===0?"#dfdfdf":"#b1b1b1"};">`;
      fields.forEach(function (field) {
        bodyTag += `<td>${val[field]}</td>`;
      });
      bodyTag += '</tr>';
    });

    bodyTag += '</tbody>'
    console.log(bodyTag);

    return bodyTag;
  }
showTable(objAry);