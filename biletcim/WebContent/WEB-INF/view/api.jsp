<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Api Page</title>
</head>
<body>




<script type="text/javascript">

var xhr = new XMLHttpRequest();
var url = 'https://api.turkishairlines.com/test/getAvailability';
xhr.open('POST', url);
xhr.setRequestHeader('apisecret', 'eb5d3e6148284a7b91c646afe8c433ae');
xhr.setRequestHeader('Content-Type', 'application/json');
xhr.setRequestHeader('apikey', 'l7xxc7cf29ae22e74bada8787d9f8240513e');
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
        alert('Status: '+this.status+'\nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'\nBody: '+this.responseText);
    }
};
xhr.send('{  "ReducedDataIndicator":false,  "RoutingType":"r",  "PassengerTypeQuantity":[    {      "Code":"adult",      "Quantity":1    },    {      "Code":"child",      "Quantity":1    },    {      "Code":"infant",      "Quantity":0    }  ],  "OriginDestinationInformation":[    {      "DepartureDateTime":{        "WindowAfter":"P0D",        "WindowBefore":"P0D",        "Date":"14OCT"      },      "OriginLocation":{        "LocationCode":"IST",        "MultiAirportCityInd":false      },      "DestinationLocation":{        "LocationCode":"ESB",        "MultiAirportCityInd":false      },      "CabinPreferences":[        {          "Cabin":"ECONOMY"        },        {          "Cabin":"BUSINESS"        }      ]    },    {      "DepartureDateTime":{        "WindowAfter":"P0D",        "WindowBefore":"P0D",        "Date":"09JAN"      },      "OriginLocation":{        "LocationCode":"ESB",        "MultiAirportCityInd":false      },      "DestinationLocation":{        "LocationCode":"IST",        "MultiAirportCityInd":false      },      "CabinPreferences":[        {          "Cabin":"ECONOMY"        },        {          "Cabin":"BUSINESS"        }      ]    }  ]}');


</script>
</body>
</html>