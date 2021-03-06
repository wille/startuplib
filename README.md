# startuplib

Library for adding your Java application to startup on many different operating systems

## How it works

### Windows

Writes registry key to ```HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run```

### macOS

Writes [launch agent](https://developer.apple.com/library/mac/documentation/MacOSX/Conceptual/BPSystemStartup/Chapters/CreatingLaunchdJobs.html) to ```~/Library/LaunchAgents/```

### Linux, Solaris and *BSD with XDG compliant DE

Writes [desktop entry](https://wiki.archlinux.org/index.php/Desktop_entries) to  ```~/.config/autostart/```

### Headless *nix systems

Refer to [linux-install](https://github.com/redpois0n/linux-install)

## Dependencies

- [oslib](https://github.com/redpois0n/oslib)
