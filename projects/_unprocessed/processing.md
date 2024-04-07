```ts


const {  
  gl: renderer,  
  camera,  
  scene,  
  raycaster  
} = useThree();


combo: "shift + d", global: true, label: "", onKeyDown: () => {  
  // const link = document.createElement('a')  
  // link.setAttribute('download', `canvas.png`)  // link.setAttribute('href', renderer.domElement.toDataURL('image/png').replace('image/png', 'image/octet-stream'))  // link.click()  
  // const box = new Box3().setFromObject(ref.current);  // const size = box.getSize(new Vector3());  //  // const width = Math.ceil(size.x);  // const height = Math.ceil(size.y);  // const width = 500;  // const height = 500;  //  // const renderTarget = new WebGLRenderTarget(renderer.domElement.width, renderer.domElement.height);  //  // renderer.setRenderTarget(renderTarget);  // renderer.render(scene, camera);  // renderer.setRenderTarget(null);  //  // const canvasX = (0 + 1) / 2 * renderTarget.width;  // const canvasY = (-0 + 1) / 2 * renderTarget.height;  // // const canvasX = Math.ceil(box.min.x + 1) - Math.ceil(renderTarget.width / 2);  // // const canvasY = Math.ceil(-box.min.y + 1) - Math.ceil(renderTarget.height / 2);  //  // const pixels = new Uint8Array(width * height * 4);  // renderer.readRenderTargetPixels(renderTarget, canvasX, canvasY, width, height, pixels);  //  // const imageData = new ImageData(new Uint8ClampedArray(pixels), width, height);  //  // const image = document.createElement('canvas');  // image.width = width;  // image.height = height;  // image.getContext('2d')!.putImageData(imageData, 0, 0);  //  // const link = document.createElement('a')  // link.download = 'test.png';  // link.href = image.toDataURL('test.png');  // link.click();  
  
  toPng(renderer.domElement, {  
    cacheBust: true,  
    backgroundColor: '#1C2127'  
  })  
    .then((dataUrl) => {  
      const link = document.createElement('a')  
      link.download = `${new Date().toISOString()}.png`  
      link.href = dataUrl  
      link.click()  
    })  
    .catch((err) => {  
      console.log(err)  
    });

useEffect(() => {  
  
  // const debug = {};  
  // A.as_reference()  //   .continues_with(new Ray({ js: () => Option.Some("B") }).as_reference())  //   .continues_with(new Ray({ js: () => Option.Some("C") }).as_reference())  //   .debug(debug)  
  // console.log(debug)  
  // console.log(  //   new Ray({ js: () => Option.Some('empty')})  //     .as_reference()  //     .continues_with(new Ray({ js: () => Option.Some("A") }).as_reference())  //     // .continues_with(new Ray({ js: () => Option.Some("B") }).as_reference())  //     // .continues_with(new Ray({ js: () => Option.Some("C") }).as_reference())  //     .to_wolfram_language()  // )  //  // const A = new Ray({ js: () => Option.Some('empty')})  //   .as_reference()  //   .continues_with(new Ray({ js: () => Option.Some("A") }).as_reference());  //  // A  //   .continues_with(new Ray({ js: () => Option.Some("B") }).as_reference())  //   .continues_with(new Ray({ js: () => Option.Some("C") }).as_reference())  
  // console.log(  //   A.to_wolfram_language()  // )  // console.log(  //   new Ray({ js: () => Option.Some('empty')})  //     .as_reference()  //     .continues_with(new Ray({ js: () => Option.Some("A") }).as_reference())  //     .continues_with(new Ray({ js: () => Option.Some("B") }).as_reference())  //     .continues_with(new Ray({ js: () => Option.Some("C") }).as_reference())  //     .to_wolfram_language()  // )  
  // console.log(  //   A.as_reference().to_wolfram_language()  // )}, [])  
  
// hotkeys.set(  
//   { combo: "arrowright", global: true, label: "Refresh data", onKeyDown: () => {  
//       selected.next().match({  
//         Some: (ray) => setSelected(ray),  
//         None: () => console.log('no more')  
//       })  
//     }}, { combo: "arrowleft", global: true, label: "Refresh data", onKeyDown: () => {  
//       selected.previous().match({  
//         Some: (ray) => setSelected(ray),  
//         None: () => console.log('no more')  
//       })  
//     }});  
  
const [{ x, y }, api] = useSpring(() => ({ x: 0, y: 0 }))  
  
const [position, setPosition] = useState([0, 0, 0]);  
const [movement, setMovement] = useState([0, 0, 0]);  
  
const drag = useDrag(({ down, movement: [mx, my] }) => {  
  api.start({ x: down ? mx : 0, y: down ? my : 0, immediate: down });  
  
  document.body.style.cursor = down ? 'grabbing' : 'auto';  
  
  if (down) {  
    setMovement([x.get(), -y.get(), 0]);  
  } else {  
    setPosition([position[0] + x.get(), position[1] - y.get(), 0]);  
    setMovement([0, 0, 0])  
  }  
});  
  
useFrame(() => {  
  const renderTarget = new WebGLRenderTarget(renderer.domElement.width, renderer.domElement.height);  
  
  // From a position, retrieve a directionality which defines what is at that position.  
  // const position = (position: Vector3): Extreme> => {  //   // const ray = new Raycaster(new THREEVector3(0, 0, 0), new THREEVector3(0, 0, 1))  //   // const intersections = ray.intersectObjects(scene.children, true);  //   // console.log(intersections.length)  //   // intersections.forEach(intersection => console.log(intersection.object.id))  
  //   renderer.setRenderTarget(renderTarget);  //   renderer.render(scene, camera)  //   renderer.setRenderTarget(null)  //  //   const canvasX = (0 + 1) / 2 * renderTarget.width;  //   const canvasY = (-0 + 1) / 2 * renderTarget.height;  //  //   const pixelBuffer = new Uint8Array(4);  //   renderer.readRenderTargetPixels(renderTarget, canvasX, canvasY, 1, 1, pixelBuffer);  //  //   // Access pixel values  //   const red = pixelBuffer[0];  //   const green = pixelBuffer[1];  //   const blue = pixelBuffer[2];  //   const alpha = pixelBuffer[3];  //  //   const pos = position([0, 0, 0]);});  
  
const currentPosition = add(position, movement);  
  
return (  
  <group  
    ref={ref}  
    {...drag()}  
    scale={scale}  
    position={currentPosition}  
  
    {...props}  
  >  
    <RenderedRay reference={selection} scale={scale} />  
    {/*<group position={[0, -80, 0]}>*/}  
    {/*  <Text color="white" font={JetBrainsMonoRegular} anchorX="center" anchorY="middle" scale={8.0}>*/}  
    {/*    Rewriting a Binary Superposition to a specific value*/}  
  
    {/*  </Text>*/}  
    {/*</group>*/}  
  </group>  
)
```