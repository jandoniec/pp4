const getProducts = () => {
    return fetch("/api/products")
        .then(r => r.json())
}

const createHtmlEl = (productData) => {
    const template = `
        <div class="product">
            <h4>${productData.name}</h4>
            <img src="https://ireland.apollo.olxcdn.com/v1/files/pmorttikg5u81-PL/image;s=1000x700"  alt="er"/>
            <div class="product__price">
                <span>${productData.price}</span>
                <button data-id="${productData.id}">Add to cart +</button>
            </div>
        </div>
    `
    const el = document.createElement("li");
    el.innerHTML = template.trim();

    return el;
}

(() => {
    const productList = document.querySelector("#productList");

    getProducts()
        .then(productsAsJson => productsAsJson.map(createHtmlEl))
        .then(productsAsHtml => productsAsHtml.forEach(productEl => productList.appendChild(productEl)));

})();