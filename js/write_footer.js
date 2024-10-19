

const footerElement = document.querySelector("footer");
const fetchFooter = async () => {
  try {
    const res = await fetch("/modules/footer.txt");
    const template = await res.text();

    footerElement.innerHTML = template;
  } catch (err) {
    console.log(err);
  }
};
fetchFooter();