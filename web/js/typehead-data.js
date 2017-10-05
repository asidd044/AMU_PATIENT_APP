var substringMatcher = function(strs) {
  return function findMatches(q, cb) {
    var matches, substringRegex;

    // an array that will be populated with substring matches
    matches = [];

    // regex used to determine if a string contains the substring `q`
    substrRegex = new RegExp(q, 'i');

    // iterate through the pool of strings and for any string that
    // contains the substring `q`, add it to the `matches` array
    $.each(strs, function(i, str) {
      if (substrRegex.test(str)) {
        matches.push(str);
      }
    });

    cb(matches);
  };
};

var states = ['Mumbai, Maharashtra' , 
				'Delhi, Delhi' , 
				'Bangalore, Karnataka' , 
				'Hyderabad, Telangana' , 
				'Ahmedabad, Gujarat' , 
				'Chennai, TamilNadu' , 
				'Kolkata, West Bengal' , 
				'Surat, Gujarat' , 
				'Pune, Maharashtra' , 
				'Jaipur, Rajasthan' , 
				'Lucknow, Uttar Pradesh' , 
				'Kanpur, Uttar Pradesh' , 
				'Nagpur, Maharashtra' , 
				'Indore, Madhya Pradesh' , 
				'Thane, Maharashtra' , 
				'Bhopal, Madhya Pradesh' , 
				'Visakhapatnam, Andhra Pradesh' , 
				'Pune, Maharashtra' , 
				'Patna, Bihar' , 
				'Vadodara, Gujarat' , 
				'Ghaziabad, Uttar Pradesh' , 
				'Ludhiana, Punjab' , 
				'Agra, Uttar Pradesh' , 
				'Nashik, Maharashtra' , 
				'Faridabad, Haryana' , 
				'Meerut, Uttar Pradesh' , 
				'Rajkot, Gujarat' , 
				'Kalyan-Dombivali, Maharashtra' , 
				'Vasai-Virar, Maharashtra' , 
				'Varanasi, Uttar Pradesh' , 
				'Srinagar, Jammu and Kashmir' , 
				'Aurangabad, Maharashtra' , 
				'Dhanbad, Jharkhand' , 
				'Amritsar, Punjab' , 
				'NaviMumbai, Maharashtra' , 
				'Allahabad, Uttar Pradesh' , 
				'Ranchi, Jharkhand' , 
				'Howrah, West Bengal' , 
				'Coimbatore, TamilNadu' , 
				'Jabalpur, Madhya Pradesh' , 
				'Gwalior, Madhya Pradesh' , 
				'Vijayawada, Andhra Pradesh' , 
				'Jodhpur, Rajasthan' , 
				'Madurai, TamilNadu' , 
				'Raipur, Chhattisgarh' , 
				'Kota, Rajasthan' , 
				'Guwahati, Assam' , 
				'Chandigarh, Chandigarh' , 
				'Solapur, Maharashtra' , 
				'Hubballi-Dharwad, Karnataka' , 
				'Bareilly, Uttar Pradesh' , 
				'Moradabad, Uttar Pradesh' , 
				'Mysore, Karnataka' , 
				'Gurgaon, Haryana' , 
				'Aligarh, Uttar Pradesh' , 
				'Jalandhar, Punjab' , 
				'Tiruchirappalli, TamilNadu' , 
				'Bhubaneswar, Orissa' , 
				'Salem, TamilNadu' , 
				'Mira-Bhayandar, Maharashtra' , 
				'Thiruvananthapuram, Kerala' , 
				'Bhiwandi, Maharashtra' , 
				'Saharanpur, Uttar Pradesh' , 
				'Gorakhpur, Uttar Pradesh' , 
				'Guntur, Andhra Pradesh' , 
				'Bikaner, Rajasthan' , 
				'Amravati, Maharashtra' , 
				'Noida, Uttar Pradesh' , 
				'Jamshedpur, Jharkhand' , 
				'Bhilai, Chhattisgarh' , 
				'Warangal, Telangana' , 
				'Cuttack, Orissa' , 
				'Firozabad, Uttar Pradesh' , 
				'Kochi, Kerala' , 
				'Bhavnagar, Gujarat' , 
				'Dehradun, Uttarakhand' , 
				'Durgapur, West Bengal' , 
				'Asansol, West Bengal' , 
				'Nanded, Maharashtra' , 
				'Kolhapur, Maharashtra' , 
				'Ajmer, Rajasthan' , 
				'Gulbarga, Karnataka' , 
				'Jamnagar, Gujarat' , 
				'Ujjain, Madhya Pradesh' , 
				'Loni, Uttar Pradesh' , 
				'Siliguri, West Bengal' , 
				'Jhansi, Uttar Pradesh' , 
				'Ulhasnagar, Maharashtra' , 
				'Nellore, Andhra Pradesh' , 
				'Jammu, Jammu and Kashmir' , 
				'Sangli-Miraj&Kupwad, Maharashtra' , 
				'Belgaum, Karnataka' , 
				'Mangalore, Karnataka' , 
				'Ambattur, TamilNadu' , 
				'Tirunelveli, TamilNadu' , 
				'Malegaon, Maharashtra' , 
				'Gaya, Bihar' , 
				'Jalgaon, Maharashtra' , 
				'Udaipur, Rajasthan' , 
				'Maheshtala, West Bengal' , 
				'Tirupur, TamilNadu' , 
				'Davanagere, Karnataka' , 
				'Kozhikode, Kerala' , 
				'Akola, Maharashtra' , 
				'Kurnool, Andhra Pradesh' , 
				'RajpurSonarpur, West Bengal' , 
				'Bokaro, Jharkhand' , 
				'SouthDumdum, West Bengal' , 
				'Bellary, Karnataka' , 
				'Patiala, Punjab' , 
				'Gopalpur, West Bengal' , 
				'Agartala, Tripura' , 
				'Bhagalpur, Bihar' , 
				'Muzaffarnagar, Uttar Pradesh' , 
				'Bhatpara, West Bengal' , 
				'Panihati, West Bengal' , 
				'Latur, Maharashtra' , 
				'Dhule, Maharashtra' , 
				'Rohtak, Haryana' , 
				'Korba, Chhattisgarh' , 
				'Bhilwara, Rajasthan' , 
				'Brahmapur, Orissa' , 
				'Muzaffarpur, Bihar' , 
				'Ahmednagar, Maharashtra' , 
				'Mathura, Uttar Pradesh' , 
				'Kollam, Kerala' , 
				'Avadi, TamilNadu' , 
				'Rajahmundry, Andhra Pradesh' , 
				'Kadapa, Andhra Pradesh' , 
				'Kamarhati, West Bengal' , 
				'Bilaspur, Chhattisgarh' , 
				'Shahjahanpur, Uttar Pradesh' , 
				'Bijapur, Karnataka' , 
				'Rampur, Uttar Pradesh' , 
				'Shivamogga(Shimoga), Karnataka' , 
				'Chandrapur, Maharashtra' , 
				'Junagadh, Gujarat' , 
				'Thrissur, Kerala' , 
				'Alwar, Rajasthan' , 
				'Bardhaman, West Bengal' , 
				'Kulti, West Bengal' , 
				'Kakinada, Andhra Pradesh' , 
				'Nizamabad, Telangana' , 
				'Parbhani, Maharashtra' , 
				'Tumkur, Karnataka' , 
				'Hisar, Haryana' , 
				'Ozhukarai, Puducherry' , 
				'BiharSharif, Bihar' , 
				'Panipat, Haryana' , 
				'Darbhanga, Bihar' , 
				'Bally, West Bengal' , 
				'Aizawl, Mizoram' , 
				'Dewas, Madhya Pradesh' , 
				'Ichalkaranji, Maharashtra' , 
				'Tirupati, Andhra Pradesh' , 
				'Karnal, Haryana' , 
				'Bathinda, Punjab' , 
				'Jalna, Maharashtra' , 
				'Barasat, West Bengal' , 
				'KirariSulemanNagar, Delhi' , 
				'Purnia, Bihar' , 
				'Satna, Madhya Pradesh' , 
				'Mau, Uttar Pradesh' , 
				'Sonipat, Haryana' , 
				'Farrukhabad, Uttar Pradesh' , 
				'Sagar, Madhya Pradesh' , 
				'Rourkela, Orissa' , 
				'Durg, Chhattisgarh' , 
				'Imphal, Manipur' , 
				'Ratlam, Madhya Pradesh' , 
				'Hapur, Uttar Pradesh' , 
				'Anantapur, Andhra Pradesh' , 
				'Arrah, Bihar' , 
				'Karimnagar, Telangana' , 
				'Etawah, Uttar Pradesh' , 
				'Ambernath, Maharashtra' , 
				'NorthDumdum, West Bengal' , 
				'Bharatpur, Rajasthan' , 
				'Begusarai, Bihar' , 
				'NewDelhi, Delhi' , 
				'Gandhidham, Gujarat' , 
				'Baranagar, West Bengal' , 
				'Tiruvottiyur, TamilNadu' , 
				'Puducherry, Puducherry' , 
				'Sikar, Rajasthan' , 
				'Thoothukudi, TamilNadu' , 
				'Rewa, Madhya Pradesh' , 
				'Mirzapur, Uttar Pradesh' , 
				'Raichur, Karnataka' , 
				'Pali, Rajasthan' , 
				'Ramagundam, Telangana' , 
				'Vizianagaram, Andhra Pradesh' , 
				'Katihar, Bihar' , 
				'Haridwar, Uttarakhand' , 
				'SriGanganagar, Rajasthan' , 
				'KarawalNagar, Delhi' , 
				'Nagercoil, TamilNadu' , 
				'Mango, Jharkhand' , 
				'Bulandshahr, Uttar Pradesh' , 
				'Thanjavur, TamilNadu' 
];

$('#states .typeahead').typeahead({
  hint: true,
  highlight: true,
  minLength: 1
},
{
  name: 'states',
  source: substringMatcher(states)
});




var jobtitle = ['Java, Html5' , 
				'.Net, Html5' , 
				'Html5 Css3' , 
];

$('#jobtitle .typeahead').typeahead({
  hint: true,
  highlight: true,
  minLength: 1
},
{
  name: 'jobtitle',
  source: substringMatcher(jobtitle)
});



var industry = ['Bulandshahr, Uttar Pradesh' , 
'IT-Software / Software Services' ,
'BPO / Call Centre / ITES' ,
'Automobile / Auto Anciliary / Auto Components' ,
'Construction / Engineering / Cement / Metals' ,
'Banking / Financial Services / Broking' ,
'Accounting / Finance' , 
'Advertising / PR / MR / Event Management' , 
'Agriculture / Dairyrel' , 
'Animation / Gamingrel' , 
'Architecture / Interior Designrel' , 
'Aviation / Aerospace Firmsrel' , 
'Brewery / Distilleryrel' , 
'Broadcastingrel' , 
'Ceramics / Sanitary warerel' , 
'Chemicals / PetroChemical / Plastic / Rubberrel' , 
'Consumer Electronics / Appliances / Durablesrel' , 
'Courier / Transportation / Freight / Warehousingrel' , 
'Education / Teaching / Trainingrel' , 
'Electricals / Switchgearsrel' , 
'Export / Importrel' , 
'Facility Managementrel' , 
'Fertilizers / Pesticidesrel' , 
'FMCG / Foods / Beveragerel' , 
'Food Processingrel' , 
'Fresher / Trainee / Entry Levelrel' , 
'Gems / Jewelleryrel' , 
'Glass / Glasswarerel' , 
'Government / Defencerel' , 
'Heat Ventilation / Air Conditioningrel' , 
'Industrial Products / Heavy Machineryrel' , 
'Insurancerel' , 
'Iron and Steelrel' , 
'IT-Hardware Networkingrel' , 
'KPO / Research / Analyticsrel' , 
'Legalrel' , 
'Media / Entertainment / Internetrel' , 
'Internet / Ecommercerel' , 
'Leatherrel' , 
'Medical / Healthcare / Hospitalsrel' , 
'Mining / Quarryingrel' , 
'NGO / Social Services / Regulators / Industry Associationsrel' , 
'Office Equipment / Automationrel' , 
'Oil and Gas / Energy / Power / Infrastructurerel' , 
'Pulp and Paperrel' , 
'Pharma / Biotech / Clinical Researchrel' , 
'Printing / Packagingrel' , 
'Publishingrel' , 
'Real Estate / Propertyrel' , 
'Recruitment / Staffingrel' , 
'Retail / Wholesalerel' , 
'Security / Law Enforcementrel' , 
'Semiconductors / Electronicsrel' , 
'Shipping / Marinerel' , 
'Strategy / Management Consulting Firmsrel' , 
'Sugarrel' , 
'Telecom/ISPrel' , 
'Textiles / Garments / Accessoriesrel' , 
'Travel / Hotels / Restaurants / Airlines / Railwaysrel' , 
'Tyresrel' , 
'Water Treatment / Waste Managementrel' , 
'Wellness / Fitness / Sportsrel' , 
'Other'
];

$('#industry .typeahead').typeahead({
  hint: true,
  highlight: true,
  minLength: 1
},
{
  name: 'industry',
  source: substringMatcher(industry)
});


var functionalarea = [ 'Sales, Retail, Business Development' , 
 'IT Software - Application Programming, Maintenance' , 
 'ITES, BPO, KPO, LPO, Customer Service, Operations' , 
 'Production, Manufacturing, Maintenance' , 
 'Accounts, Finance, Tax, Company Secretary, Audit' ,
 'Analytics  Business Intelligence' , 
 'Architecture, Interior Design' , 
 'Defence Forces, Security Services' , 
 'Design, Creative, User Experience' , 
 'Engineering Design, R&amp;D' , 
 'Executive Assistant, Front Office, Data Entry' , 
 'Export, Import, Merchandising' , 
 'Fashion Designing, Merchandising' , 
 'Hotels, Restaurants' , 
 'HR, Recruitment, Administration, IR' , 
 'Financial Services, Banking, Investments, Insurance' , 
 'IT Hardware, Technical Support, Telecom Engineering' , 
 'IT Software - Client/Server Programming' ,
 'IT Software - eCommerce, Internet Technologies' , 
 'IT Software - Mainframe' , 
 'IT Software - Middleware' , 
 'IT Software - Mobile' ,
 'IT Software - Other' , 
 'IT Software - System Programming' , 
 'IT Software - Telecom Software' , 
 'IT Software - DBA, Datawarehousing' , 
 'IT Software - Embedded, EDA, VLSI, ASIC, Chip Design' ,
 'IT Software - ERP, CRM' , 
 'IT Software - Network Administration, Security' , 
 'IT Software - QA &amp; Testing' , 
 'IT Software - Systems, EDP, MIS' , 
 'Journalism, Editing, Content' , 
 'Legal, Regulatory, Intellectual Property' , 
 'Marketing, Advertising, MR, PR, Media Planning' , 
 'Medical, Healthcare, R&amp;D, Pharmaceuticals, Biotechnology' , 
 'Packaging' , 
 'Self Employed, Entrepreneur, Independent Consultant' , 
 'Shipping' , 
 'Site Engineering, Project Management' , 
 'Strategy, Management Consulting, Corporate Planning' , 
 'Supply Chain, Logistics, Purchase, Materials' , 
 'Teaching, Education, Training, Counselling' , 
 'Top Management' , 
 'Travel, Tours, Ticketing, Airlines' , 
 'TV, Films, Production, Broadcasting' , 
 'Other' 
];

$('#functionalarea .typeahead').typeahead({
  hint: true,
  highlight: true,
  minLength: 1
},
{
  name: 'functionalarea',
  source: substringMatcher(functionalarea)
});


var ugqualification = ['B.Tech/B.E.' , 
'Diploma' , 
'B.Sc' , 
'B.Com' ,
'B.A' , 
'B.Arch' ,
'B.B.A' , 
'B.Ed' , 
'B.Pharma' ,
'BCA' , 
'BDS' , 
'BHM' , 
'BVSC' , 
'LLB' , 
'MBBS' , 
'Other Graduate'
];

$('#ugqualification .typeahead').typeahead({
  hint: true,
  highlight: true,
  minLength: 1
},
{
  name: 'ugqualification',
  source: substringMatcher(ugqualification)
});



var pgqualification = [
'MBA/PGDM' , 
'M.Tech' , 
'MCA' , 
'M.Sc' , 
'CA' , 
'CS' , 
'ICWA' , 
'Integrated PG' , 
'LLM' , 
'M.A' , 
'M.Arch' , 
'M.Com' , 
'M.Ed' ,
'M.Pharma' , 
'M.S/M.D' , 
'MVSC' , 
'PG Diploma' , 
'Other'
];

$('#pgqualification .typeahead').typeahead({
  hint: true,
  highlight: true,
  minLength: 1
},
{
  name: 'pgqualification',
  source: substringMatcher(pgqualification)
});

var doctorate = [
'Ph.D' ,
'M.Phil.' ,
'Other Doctorate' ,
];

$('#doctorate .typeahead').typeahead({
  hint: true,
  highlight: true,
  minLength: 1
},
{
  name: 'doctorate',
  source: substringMatcher(doctorate)
});