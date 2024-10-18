
const headerElement = document.querySelector("header");

const fetchHeader = async () => {
  try {
    const res = await fetch("./header.txt");
    const template = await res.text();

    headerElement.innerHTML = template;
  } catch (err) {
    console.log(err);
  }
};

fetchHeader();