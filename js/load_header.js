const headerElement = document.querySelector("#header");

const fetchHeader = async () => {
  try {
    const res = await fetch("/modules/header.txt");
    const template = await res.text();

    headerElement.innerHTML = template;

    header_addEventListener();
    
  } catch (err) {
    console.log(err);
  }
};

fetchHeader();



function header_addEventListener() {
  /*********** menu.js start ***********/
  const nav_menuButton = document.querySelector('#toggle-menu');
  // console.log(nav_menuButton);
  nav_menuButton.addEventListener('click', function(event) {
      event.preventDefault();
      const menu = document.querySelector('#main-menu');
      menu.classList.toggle('is-open');
  });
  /*********** menu.js end ***********/
  /*********** search.js start ***********/
  const search_input = document.querySelector(".search-input");
  
  const search_handleInputChange = (e) => {
      if (e.target.value && !search_input.classList.contains("search--touched")) {
          search_input.classList.add("search--touched");
      } else if (!e.target.value && search_input.classList.contains("search--touched")) {
          search_input.classList.remove("search--touched");
      }
  }
  search_input.addEventListener("input", search_handleInputChange);
  
  const search_toggle = document.querySelector('#search__menu-toggle');
  search_toggle.addEventListener('focus', function(event) {
      event.preventDefault();
      const menu = document.querySelector('#search__menu-list');
      menu.style.display = "block";
  });
  search_toggle.addEventListener('blur', function(event) {
      event.preventDefault();
      const menu = document.querySelector('#search__menu-list');
      menu.style.display = "none";
  });
  /*********** search.js end ***********/
}
